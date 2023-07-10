package com.example.spring_tp_vendredi_07072023.exception;

public class UserOrPasswordExistException extends RuntimeException{

        public UserOrPasswordExistException(String message) {
            super(message);
        }
}
