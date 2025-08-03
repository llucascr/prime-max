package core.api.prime_max.services.users;

import core.api.prime_max.dto.enums.UserPlan;
import core.api.prime_max.dto.request.UserRequest;
import core.api.prime_max.dto.response.UserResponse;
import core.api.prime_max.exceptions.users.UserAlreadyExist;
import core.api.prime_max.exceptions.users.UserNotFound;
import core.api.prime_max.models.users.User;
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

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServices {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserResponse createUser(UserRequest userRequest) {

        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            log.info("User with email " + userRequest.getEmail() + " already exist", HttpStatus.CONFLICT);
            throw new UserAlreadyExist("User with email " + userRequest.getEmail() + " already exist");
        }

        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .plan(UserPlan.FREE)
                .createAt(LocalDateTime.now())
                .active(true)
                .build();

        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }

    public UserResponse listUserById(Long id) {
        Optional<User> userOp = userRepository.findById(id);
        return modelMapper.map(userOp.orElseThrow(() -> new UserNotFound("User with ID " + id + " not found")), UserResponse.class);
    }

    public Page<UserResponse> listUsers(int page, int numberOfUsers, String name) {
        Pageable pageable = PageRequest.of(page, numberOfUsers);
        Page<User> users = userRepository.findByName(name, pageable);

        List<UserResponse> userResponses = users.getContent().stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .toList();

        return new PageImpl<>(userResponses, pageable, users.getTotalElements());
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("User with ID " + id + " not found"));

        User userUpdated = User.builder()
                .id(user.getId())
                .name(userRequest.getName() != null ? userRequest.getName() : user.getName())
                .email(userRequest.getEmail() != null ? userRequest.getEmail() : user.getName())
                .password(userRequest.getPassword() != null ? userRequest.getPassword() : user.getPassword())
                .plan(user.getPlan())
                .createAt(user.getCreateAt())
                .active(user.getActive())
                .build();

        return modelMapper.map(userRepository.save(userUpdated), UserResponse.class);
    }

}
