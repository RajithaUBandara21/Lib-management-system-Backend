package com.example.library_management_system.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(String message)
    {
        super(message);
    }
}
