package com.example.testtaskforamazon.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDTO {
    int status;
    String message;
    Date timestamp;

    public ErrorDTO(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
