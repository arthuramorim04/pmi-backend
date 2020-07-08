package com.arthuramorim.apispring.resoucers.exceptions;

import com.arthuramorim.apispring.services.exceptions.DatabaseException;
import com.arthuramorim.apispring.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    //Tratamento Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException erros, HttpServletRequest request){
        String errorMsg = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(Instant.now(),status.value(),errorMsg,erros.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    //Trata erro de database
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandarError> database(DatabaseException erros, HttpServletRequest request){
        String errorMsg = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarError err = new StandarError(Instant.now(),status.value(),errorMsg,erros.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
