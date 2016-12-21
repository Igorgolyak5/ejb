package com.ejb.model;

/**
 * Created by Igor on 19.12.16.
 */
public class ErrorMessage {

    private String error;

    public ErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
