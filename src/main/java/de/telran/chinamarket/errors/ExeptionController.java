package de.telran.chinamarket.errors;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

/**
 * Configuration for Web Security
 *
 * @author Hanna Akymenko on 04.02.2024.
 */

@ControllerAdvice
@Slf4j
public class ExeptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestExeption(Exception e) {
        log.error(e.toString());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(Exception e) {
        log.error(e.toString());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(Exception e){
        log.error(e.toString());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }

}
