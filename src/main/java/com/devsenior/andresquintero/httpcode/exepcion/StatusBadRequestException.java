package com.devsenior.andresquintero.httpcode.exepcion;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="El valor proporcionado no es válido")
public class StatusBadRequestException extends RuntimeException {
   
    }

