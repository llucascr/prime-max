package core.api.prime_max.exceptions.followers;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class AlreadyFollowThisUser extends RuntimeException implements ApiExceptionInterface {

    private final String code = "ALREADY_FOLLOW_THIS_USER";
    private String message;

    public AlreadyFollowThisUser(String message) {
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
