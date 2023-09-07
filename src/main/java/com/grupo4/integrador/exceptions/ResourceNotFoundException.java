package com.grupo4.integrador.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceId;
    private final String resource;

    public ResourceNotFoundException(String resourceId, String resource) {
        super();
        this.resourceId = resourceId;
        this.resource = resource;
    }
}
