package com.ejb.exception;

/**
 * Created by Igor on 19.12.16.
 */
public class CatalogNotFoundException extends Exception{

    public CatalogNotFoundException(String message, Throwable throwable){
        super(message,throwable);
    }

    public CatalogNotFoundException(String message){
        super(message);
    }
}
