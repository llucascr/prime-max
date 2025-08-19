package core.api.prime_max.exceptions.category;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class CategoryDeleteException extends RuntimeException implements ApiExceptionInterface {

    private final String code = "CATEGORY_DELETE_CONFLICT";
    private String message;

    public CategoryDeleteException(String message) {
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
