package com.example.librarymanagementstudent.exception;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String message){
        super(message);
    }
}
