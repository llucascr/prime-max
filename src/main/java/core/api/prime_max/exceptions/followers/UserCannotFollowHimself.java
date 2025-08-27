package core.api.prime_max.exceptions.followers;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class UserCannotFollowHimself extends RuntimeException implements ApiExceptionInterface {

    private final String code = "USER_CANNOT_FOLLOW_HIMSELF";
    private String message;

    public UserCannotFollowHimself(String message) {
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
        return HttpStatus.CONFLICT;
    }
}
