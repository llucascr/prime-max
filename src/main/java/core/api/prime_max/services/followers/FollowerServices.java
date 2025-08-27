package core.api.prime_max.services.followers;

import core.api.prime_max.dto.request.followers.FollowerRequest;
import core.api.prime_max.dto.response.followers.FollowerResponse;
import core.api.prime_max.dto.response.followers.ListFollowerResponse;
import core.api.prime_max.exceptions.followers.AlreadyFollowThisUser;
import core.api.prime_max.exceptions.followers.UserCannotFollowHimself;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FollowerServices {

    private final UserRepository userRepository;
    private final FollowerRepository followerRepository;
    private final ModelMapper modelMapper;

    public FollowerResponse followUser(FollowerRequest request) {

        if (request.getUserId().equals(request.getFollowId())) {
            throw new UserCannotFollowHimself("User cannot follow himself");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFound("User with ID " + request.getUserId() + " not found"));

        User follower = userRepository.findById(request.getFollowId())
                .orElseThrow(() -> new UserNotFound("User with ID " + request.getFollowId() + " not found"));

        boolean alreadyFollowing = user.getFollowers().stream()
                .anyMatch(f -> f.getUser().getId().equals(follower.getId()));

        if (alreadyFollowing) {
            throw new AlreadyFollowThisUser("Already following this user");
        }

        Follower follow = Follower.builder()
                .nameFollower(follower.getName())
                .user(user)
                .build();

        user.getFollowers().add(follow);
        followerRepository.save(follow);

        List<ListFollowerResponse> followerDtos = user.getFollowers().stream()
                .map(f -> new ListFollowerResponse(f.getId(), f.getNameFollower()))
                .toList();

        return FollowerResponse.builder()
                .userName(user.getName())
                .followers(followerDtos)
                .build();
    }

    public Page<ListFollowerResponse> listFollowers(int page, int numberOfFollowers, Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFound("User with ID " + userId + " not found"));

        Pageable pageable = PageRequest.of(page, numberOfFollowers);
        Page<Follower> followers = followerRepository.findAllPageble(pageable, userId);

        List<ListFollowerResponse> followerResponses = followers.getContent().stream()
                .map(follower -> modelMapper.map(follower, ListFollowerResponse.class))
                .toList();
        return new PageImpl<>(followerResponses, pageable, followers.getTotalElements());
    }

}
