package com.infosys.anz.restapp.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.Data;

/**
 * A Custom exception handler to handle bad requests
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Data
    public class ErrorResponse {

        public ErrorResponse(String message, List<String> details) {
            super();
            this.message = message;
            this.details = details;
        }

        private String message;

        private List<String> details;
    }
}