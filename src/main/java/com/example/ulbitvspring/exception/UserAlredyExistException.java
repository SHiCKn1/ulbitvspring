package com.example.ulbitvspring.exception;

public class UserAlredyExistException extends Exception{
    public UserAlredyExistException(String message) {
        super(message);
    }
}
