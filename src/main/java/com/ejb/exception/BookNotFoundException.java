package com.ejb.exception;

/**
 * Created by Igor on 22.12.16.
 */
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message, Throwable throwable){
        super(message,throwable);
    }

    public BookNotFoundException(String message){
        super(message);
    }

}
