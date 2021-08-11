package com.example.airline_reservation.AOP;

import com.example.airline_reservation.ExceptionHandling.MyCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TraceAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MyCustomException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("status", 400);
        error.put("data", null);
        error.put("isSuccessful", false);


//        return handleExceptionInternal(ex, ex.getMessage(),
//                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
