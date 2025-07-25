package core.api.prime_max.api;

import core.api.prime_max.models.TestFlow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(path = "/api/v2")
public class TestController {

    @GetMapping(path = "/address")
    public ResponseEntity<TestFlow> test() throws UnknownHostException {
        TestFlow response = TestFlow.builder()
                                    .hash(UUID.randomUUID().toString())
                                    .owner(InetAddress.getLocalHost().getHostName())
                                    .address(InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()))
                                    .date(new Date().toString())
                                    .build();

        log.info("owner: {}  address: {}", response.getOwner(), response.getAddress());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
