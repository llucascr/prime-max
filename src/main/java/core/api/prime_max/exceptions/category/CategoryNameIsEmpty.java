package core.api.prime_max.exceptions.category;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class CategoryNameIsEmpty extends RuntimeException implements ApiExceptionInterface {

    private final String code = "NAME_IS_EMPTY";
    private String message;

    public CategoryNameIsEmpty(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
