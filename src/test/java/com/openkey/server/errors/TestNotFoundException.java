package com.openkey.server.errors;

import java.util.function.Supplier;

public class TestNotFoundException extends Exception {
    public TestNotFoundException(String message){
        super(message);
    }
}
