package core.api.prime_max.exceptions.followers;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class FollowerNotFound extends RuntimeException implements ApiExceptionInterface {

    private final String code = "FOLLOWER_NOT_FOUND";
    private String message;

    public FollowerNotFound(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
