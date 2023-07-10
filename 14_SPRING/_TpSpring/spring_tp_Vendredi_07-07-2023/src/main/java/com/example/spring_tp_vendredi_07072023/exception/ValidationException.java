package com.example.spring_tp_vendredi_07072023.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class ValidationException extends ResponseEntityExceptionHandler {

        public ValidationException(String message) {
            super();
        }

}
