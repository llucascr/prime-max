package core.api.prime_max.exceptions;

import org.springframework.http.HttpStatus;

public interface ApiExceptionInterface {
    String getCode();
    String getMessage();
    HttpStatus getHttpStatus();
}
