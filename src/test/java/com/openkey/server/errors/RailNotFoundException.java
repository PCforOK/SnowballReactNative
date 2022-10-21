package com.openkey.server.errors;

import java.util.function.Supplier;

public class RailNotFoundException extends Exception {
    public RailNotFoundException(String message){
        super(message);
    }
}
