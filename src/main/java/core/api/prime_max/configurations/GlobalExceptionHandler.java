package core.api.prime_max.configurations;

import core.api.prime_max.exceptions.ErrorResponse;
import core.api.prime_max.exceptions.ApiExceptionInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /*@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handlerApiException(RuntimeException contract) {
        if (contract instanceof ApiExceptionInterface apiEx) {
            HttpStatus status = apiEx.getHttpStatus();
            ErrorResponse error = new ErrorResponse(
                    apiEx.getCode(),
                    apiEx.getMessage(),
                    status.value()
            );
            return ResponseEntity.status(status).body(error);
        }
        ErrorResponse error = new ErrorResponse(
                "INTERNAL_SERVER_ERROR",
                "Ocorreu um erro inesperado",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }*/

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "INTERNAL_SERVER_ERROR",
                "Ocorreu um erro inesperado",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }*/

}