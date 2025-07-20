package webapp.astrocatalog.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponceHttpException(ResponseStatusException ex, WebRequest request) {
        System.out.println("Глобальный хендлер сработал: " + ex.getReason());
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder("Validation failed:\n");
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            sb.append("- ").append(error.getField())
                    .append(": ").append(error.getDefaultMessage()).append("\n");
        });

        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }



}
