package com.example.proiect_final.exceptionhandling;

import com.example.proiect_final.exceptions.InsufficientBalanceError;
import com.example.proiect_final.exceptions.InvalidUserAge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class InsufficientBalanceErrorHandling {

    @ExceptionHandler({InsufficientBalanceError.class})
    public ResponseEntity<?> handleException(RuntimeException e) {
        List<String> responses = new ArrayList<>();
        responses.add("Insufficient balance");

        return ResponseEntity.badRequest().body(responses);
    }
}
