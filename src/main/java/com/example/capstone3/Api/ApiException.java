package com.example.capstone3.Api;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ApiException extends RuntimeException{
    private String message;
    public ApiException(String message){
        super(message);
    }
}
