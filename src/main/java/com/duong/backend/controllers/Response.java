package com.duong.backend.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Response {
    private String message;
    private boolean error;
    private Map<String, Object> data;
}
