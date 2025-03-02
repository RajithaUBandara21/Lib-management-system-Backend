package com.example.library_management_system.advice;


import com.example.library_management_system.util.StandedResponce;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExeptionHandler {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<StandedResponce> handleNotFoundException(ChangeSetPersister.NotFoundException e) {
       return new ResponseEntity<StandedResponce>(
                new StandedResponce(404, "Not Found sadsa", e.getMessage()+"🥲"), HttpStatus.NOT_FOUND);

    }
}
