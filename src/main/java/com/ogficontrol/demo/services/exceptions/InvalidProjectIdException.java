package com.ogficontrol.demo.services.exceptions;

public class InvalidProjectIdException extends RuntimeException  {

    public InvalidProjectIdException(String message) {
        super(message);
    }
}
