package com.exadel.catalog.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

    /*400*/
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> illegalArgumentExceptionHandler(HttpServletRequest request, IllegalArgumentException exception) {
        return getResponse(request, HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    /*400*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) {

        String errorMessage = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        return getResponse(request, HttpStatus.BAD_REQUEST, errorMessage);

    }

    /*400*/
    @ExceptionHandler(RequestArgumentIsNotPresentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> requestArgumentIsNotPresentException(HttpServletRequest request, RequestArgumentIsNotPresentException exception) {

        //String errorMessage = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        return getResponse(request, HttpStatus.BAD_REQUEST, exception.getMessage());

    }

    /*400*/
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?>constraintViolationException(HttpServletRequest request, ConstraintViolationException exception){

        return getResponse(request, HttpStatus.BAD_REQUEST, exception.getMessage());

    }

    /*400*/
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?>invalidFormatException(HttpServletRequest request, InvalidFormatException exception){

        return getResponse(request, HttpStatus.BAD_REQUEST, exception.getMessage());

    }


    /*404*/
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> entityNotFoundExceptionHandler(HttpServletRequest request, EntityNotFoundException exception) {
        return getResponse(request, HttpStatus.NOT_FOUND, exception.getMessage());
    }

    /*409*/
    @ExceptionHandler(DuplicateNameException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ResponseEntity<?> duplicateNameExceptionHandler(HttpServletRequest request, DuplicateNameException exception) {
        return getResponse(request, HttpStatus.CONFLICT, exception.getMessage());
    }


    private ResponseEntity<?> getResponse(HttpServletRequest request, HttpStatus httpStatus, String message) {
        log.error("Exception raised = {} :: URL = {}", message, request.getRequestURL());

        Map<String, Object> response = new HashMap<>();
        response.put("code", httpStatus.value() + " / " + httpStatus.getReasonPhrase());
        response.put("message", message);
        response.put("path", request.getRequestURI());
        return new ResponseEntity<>(response, httpStatus);
    }
}
