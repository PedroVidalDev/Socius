package com.pedro.socius.infrastructure.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.Repeatable;

@RestControllerAdvice
public class ErrorException {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidacaoAgendamento.class)
    public ResponseEntity validacaoAgendamento(ValidacaoAgendamento e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
