package core.api.prime_max.api.followers;

import core.api.prime_max.dto.request.followers.FollowerRequest;
import core.api.prime_max.dto.response.followers.FollowerResponse;
import core.api.prime_max.dto.response.followers.ListFollowerResponse;
import core.api.prime_max.services.followers.FollowerServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/v2/followers")
public class FollowerController {

    private final FollowerServices followerService;

    @PostMapping(path = "/follow")
    public ResponseEntity<FollowerResponse> followUser(@RequestBody FollowerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(followerService.followUser(request));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ListFollowerResponse>> getFollowers(@RequestParam(defaultValue = "0", required = false) int page,
                                                                   @RequestParam(defaultValue = "10", required = false) int numberOfFollowers,
                                                                   @RequestParam Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(followerService.listFollowers(page, numberOfFollowers, userId).getContent());
    }

}
