package core.api.prime_max.api.users;

import core.api.prime_max.dto.request.UserRequest;
import core.api.prime_max.dto.response.UserResponse;
import core.api.prime_max.services.users.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/v2/users")
public class UserController {

    private final UserServices userService;

    @PostMapping(path = "/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }

    @GetMapping(path = "/listUserById")
    public ResponseEntity<UserResponse> listUserById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listUserById(id));
    }

    @GetMapping(path = "/listUsers")
    public ResponseEntity<List<UserResponse>> listUsers(
            @RequestParam int page,
            @RequestParam int numberOfUsers,
            @RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listUsers(page, numberOfUsers, name).getContent());
    }

}
