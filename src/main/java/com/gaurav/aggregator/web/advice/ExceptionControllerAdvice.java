package com.gaurav.aggregator.web.advice;

import com.gaurav.aggregator.common.APILogger;
import com.gaurav.aggregator.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @Autowired
    private APILogger logger;

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> genericErrorHandler(Exception exception) {
        return handleException(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private ResponseEntity<ErrorResponse> handleException(Exception exception, HttpStatus status) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(status.value());
        error.setMessage(exception.getMessage());
        logger.errorResponse(LOG, exception, error);
        return new ResponseEntity<>(error, status);
    }
}
