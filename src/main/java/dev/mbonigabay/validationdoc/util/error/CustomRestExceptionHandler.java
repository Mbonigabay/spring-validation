package dev.mbonigabay.validationdoc.util.error;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomRestExceptionHandler  extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(CustomRestExceptionHandler.class);
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatusCode status, final WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final List<String> errors = new ArrayList<String>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }
    
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        //
        final List<String> errors = new ArrayList<String>();
        for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
        }

        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
