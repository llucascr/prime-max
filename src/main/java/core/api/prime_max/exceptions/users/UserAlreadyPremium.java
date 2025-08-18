package core.api.prime_max.exceptions.users;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class UserAlreadyPremium extends RuntimeException implements ApiExceptionInterface {

    private final String code = "USER_ALREADY_IS_PREMIUM";
    private String message;

    public UserAlreadyPremium(String message) {
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
