package com.example.proiect_final.exceptionhandling;

import com.example.proiect_final.exceptions.InvalidUserAge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class InvalidUserAgeErrorHandling {

    @ExceptionHandler({InvalidUserAge.class})
    public ResponseEntity<?> handleException(RuntimeException e) {
        List<String> responses = new ArrayList<>();
        responses.add("Can't create an account if you are under 14 years old");

        return ResponseEntity.badRequest().body(responses);
    }

}
