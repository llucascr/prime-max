package core.api.prime_max.api.users;

import core.api.prime_max.dto.request.UserRequest;
import core.api.prime_max.dto.response.UserResponse;
import core.api.prime_max.services.users.UserServices;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
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

    @PostMapping(path = "/create")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }

    @GetMapping(path = "/listById")
    public ResponseEntity<UserResponse> listUserById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listUserById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<UserResponse>> listUsers(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int numberOfUsers,
            @RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listUsers(page, numberOfUsers, name).getContent());
    }

    @PutMapping(path = "/update")
    public ResponseEntity<UserResponse> updateUser(@RequestParam Long id, @Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.updateUser(id, userRequest));
    }

}
