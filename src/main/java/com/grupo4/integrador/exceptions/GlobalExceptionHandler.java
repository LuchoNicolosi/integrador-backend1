package com.grupo4.integrador.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({InternalServerException.class})
    public ResponseEntity<?> internalServerException(InternalServerException ex, WebRequest req) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest req) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Recurso no encontrado : " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> badRequestException(BadRequestException ex, WebRequest req) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error al crear el recurso : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
