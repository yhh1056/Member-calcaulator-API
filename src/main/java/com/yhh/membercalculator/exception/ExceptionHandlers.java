package com.yhh.membercalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yhh1056
 * @since 2021/01/15
 */
@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorResponse> handleConstraintViolationException(RuntimeException e) {
        final ErrorResponse response = ErrorResponse.of(ErrorCode.MEMID_NOT_FOUNDED);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
