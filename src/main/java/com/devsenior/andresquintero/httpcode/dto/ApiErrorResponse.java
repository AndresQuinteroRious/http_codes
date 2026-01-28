package com.devsenior.andresquintero.httpcode.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiErrorResponse<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private T message;
    private String path;

    

    public ApiErrorResponse(LocalDateTime timestamp,HttpStatus  status,  T message, String path) {
       this(timestamp, status.value(), status.getReasonPhrase(), message, path);
    }



    public ApiErrorResponse(LocalDateTime timestamp, int status, String error, T message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }


    // Getters and setters

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public T getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

}
