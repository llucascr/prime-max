package core.api.prime_max.services.followers;


import core.api.prime_max.dto.response.followers.FollowerResponse;
import core.api.prime_max.dto.response.followers.SetFollowerResponse;
import core.api.prime_max.exceptions.followers.AlreadyFollowThisUser;
import core.api.prime_max.exceptions.followers.FollowerNotFound;
import core.api.prime_max.exceptions.followers.UserCannotFollowHimself;
import core.api.prime_max.exceptions.users.InactiveUser;
import core.api.prime_max.exceptions.users.UserNotFound;
import core.api.prime_max.models.followers.Follower;
import core.api.prime_max.models.users.User;
import core.api.prime_max.repositories.followers.FollowerRepository;
import core.api.prime_max.repositories.users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class FollowerServices {

    private final UserRepository userRepository;
    private final FollowerRepository followerRepository;
    private final ModelMapper modelMapper;

    public FollowerResponse followUser(Long userId, Long followerId) {

        if (userId.equals(followerId)) {
            throw new UserCannotFollowHimself("User cannot follow himself");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User with ID " + userId + " not found"));

        if (user.getActive() == false) {
            throw new InactiveUser("You cannot follow an inactive user");
        }

        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new UserNotFound("User with ID " + followerId + " not found"));

        if (follower.getActive() == false) {
            throw new InactiveUser("You cannot follow an inactive user");
        }

        boolean alreadyFollowing = user.getFollowers().stream()
                .anyMatch(f -> f.getFollowerId().equals(follower.getId())
                        && f.getUser().getId().equals(user.getId()));

        if (alreadyFollowing) {
            throw new AlreadyFollowThisUser("User " + user.getName() + " is already followed by " + follower.getName());
        }

        Follower follow = Follower.builder()
                .nameFollower(follower.getName())
                .followerId(follower.getId())
                .user(user)
                .build();

        user.getFollowers().add(follow);
        followerRepository.save(follow);

        Set<SetFollowerResponse> followerDtos = user.getFollowers().stream()
                .map(f -> new SetFollowerResponse(f.getId(), f.getNameFollower()))
                .collect(Collectors.toSet());

        return FollowerResponse.builder()
                .userName(user.getName())
                .followers(followerDtos)
                .build();
    }

    public FollowerResponse unfollowUser(Long userId, Long followerId) {
        if (userId.equals(followerId)) {
            throw new UserCannotFollowHimself("User cannot follow himself");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User with ID " + userId + " not found"));

        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new UserNotFound("User with ID " + followerId + " not found"));

        Follower following = followerRepository.findByUserIdFollowerId(userId, followerId)
                .orElseThrow(() -> new FollowerNotFound("User with " + userId + "and follower with " + followerId
                        + " are not following each other"));

        followerRepository.delete(following);
        user.getFollowers().removeIf(f -> f.getId().equals(followerId));

        Set<SetFollowerResponse> followerDtos = user.getFollowers().stream()
                .map(f -> new SetFollowerResponse(f.getId(), f.getNameFollower()))
                .collect(Collectors.toSet());

        return FollowerResponse.builder()
                .userName(user.getName())
                .followers(followerDtos)
                .build();
    }

    public Page<FollowerResponse> listFollowers(int page, int numberOfFollowers, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User with ID " + userId + " not found"));

        Pageable pageable = PageRequest.of(page, numberOfFollowers);
        Page<Follower> followers = followerRepository.findAllPageble(pageable, userId);

        Set<SetFollowerResponse> setfollowerResponses = followers.getContent().stream()
                .map(follower -> modelMapper.map(follower, SetFollowerResponse.class))
                .collect(Collectors.toSet());

        List<FollowerResponse> followerResponses = Collections.singletonList(FollowerResponse.builder()
                .userName(user.getName())
                .followers(setfollowerResponses)
                .build());

        return new PageImpl<>(followerResponses, pageable, followers.getTotalElements());
    }

}
