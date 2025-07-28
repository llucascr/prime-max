package core.api.prime_max.services.users;

import core.api.prime_max.dto.request.UserRequest;
import core.api.prime_max.dto.response.UserResponse;
import core.api.prime_max.exceptions.users.UserNotFound;
import core.api.prime_max.models.users.User;
import core.api.prime_max.repositories.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServices {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserResponse createUser(UserRequest userRequest) {

        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .plan(userRequest.getPlan())
                .createAt(userRequest.getCreateAt())
                .active(userRequest.getActive())
                .build();

        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }

    public UserResponse listUserById(Long id) {
        Optional<User> userOp = userRepository.findById(id);
        return modelMapper.map(userOp.orElseThrow(() -> new UserNotFound("User with Id " + id + " not found")), UserResponse.class);
    }

    public Page<UserResponse> listUsers(int page, int numberOfUsers, String name) {
        Pageable pageable = PageRequest.of(page, numberOfUsers);
        Page<User> users = userRepository.findByName(name, pageable);

        List<UserResponse> userResponses = users.getContent().stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .toList();

        return new PageImpl<>(userResponses, pageable, users.getTotalElements());
    }

}
