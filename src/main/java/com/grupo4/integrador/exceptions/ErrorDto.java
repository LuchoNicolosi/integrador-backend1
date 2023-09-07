package com.grupo4.integrador.exceptions;

import lombok.Getter;

@Getter
public class ErrorDto {
    private final String status;
    private final String message;

    public ErrorDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
