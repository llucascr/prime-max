package core.api.prime_max.exceptions.category;

import core.api.prime_max.exceptions.ApiExceptionInterface;
import org.springframework.http.HttpStatus;

public class CategoryNotFound extends RuntimeException implements ApiExceptionInterface {

    private final String code = "CATEGORY_NOT_FOUND";
    private String message;

    public CategoryNotFound(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {return code;}

    @Override
    public String getMessage() {return message;}

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
