package com.openkey.server.errors;

public class AppNotFoundException extends Exception{
    public AppNotFoundException(String message){
        super(message);
    }
}
