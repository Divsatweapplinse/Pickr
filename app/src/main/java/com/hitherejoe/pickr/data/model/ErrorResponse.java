package com.hitherejoe.pickr.data.model;

public class ErrorResponse {
    public Error error;
    public class Error {
        public int code;
        public String message;
    }
}