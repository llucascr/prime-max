package core.api.prime_max.services.users;

import core.api.prime_max.dto.request.UserRequest;
import core.api.prime_max.dto.response.UserResponse;
import core.api.prime_max.models.users.User;
import core.api.prime_max.repositories.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
                .build();

        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }

}
