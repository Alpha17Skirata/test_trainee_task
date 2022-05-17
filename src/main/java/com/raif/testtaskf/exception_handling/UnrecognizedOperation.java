package com.raif.testtaskf.exception_handling;

public class UnrecognizedOperation extends RuntimeException{
    public UnrecognizedOperation(String message) {
        super(message);
    }
}
