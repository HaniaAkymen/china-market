package de.telran.chinamarket.errors;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Configuration for handling exceptions globally in the application.
 * This controller advice intercepts and handles various types of exceptions thrown by controllers.
 * Конфигурация для обработки исключений глобально в приложении.
 * Этот контроллер обрабатывает различные типы исключений, возникающих в контроллерах.
 * @author Hanna Akymenko
 * version 1.0
 * @since 2024-02-04
 */

@ControllerAdvice
@Slf4j
public class ExeptionController {
    /**
     * Handles BadRequestException and returns an appropriate ResponseEntity.
     * Обрабатывает BadRequestException и возвращает соответствующий ResponseEntity.
     * @param e the exception to be handled / e Исключение, которое нужно обработать.
     * @return ResponseEntity with an error message and HTTP status code 400 (Bad Request) / ResponseEntity с сообщением об ошибке и HTTP-статусом 400 (Неверный запрос).
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestExeption(Exception e) {
        log.error(e.toString());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles EntityNotFoundException and returns an appropriate ResponseEntity.
     * Обрабатывает EntityNotFoundException и возвращает соответствующий ResponseEntity.
     * @param e the exception to be handled.
     * @return ResponseEntity with an error message and HTTP status code 404 (Not Found) / ResponseEntity с сообщением об ошибке и HTTP-статусом 404 (Не найдено)
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(Exception e) {
        log.error(e.toString());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles MethodArgumentNotValidException and returns an appropriate ResponseEntity.
     * Обрабатывает MethodArgumentNotValidException и возвращает соответствующий ResponseEntity.
     * @param e the exception to be handled.
     * @return ResponseEntity with an error message and HTTP status code 400 (Bad Request) / ResponseEntity с сообщением об ошибке и HTTP-статусом 400 (Неверный запрос)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(Exception e){
        log.error(e.toString());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
