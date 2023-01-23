package com.example.proiect_final.exceptionhandling;

import com.example.proiect_final.exceptions.InsufficientStockError;
import com.example.proiect_final.exceptions.InvalidUserAge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class InsufficientStockErrorHandling {

    @ExceptionHandler({InsufficientStockError.class})
    public ResponseEntity<?> handleException(RuntimeException e) {
        List<String> responses = new ArrayList<>();
        responses.add("Insufficient stock");

        return ResponseEntity.badRequest().body(responses);
    }

}
