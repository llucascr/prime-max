package core.api.prime_max.exceptions.category;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class CategoryAlreadyExist extends RuntimeException implements ApiExceptionInterface {

    private final String code = "CATEGORY_ALREADY_EXIST";
    private String message;

    public CategoryAlreadyExist(String message) {
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
        return HttpStatus.CONFLICT;
    }
}
