package com.duong.backend.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Response {
    @NotNull String message;
    @NotNull boolean error;
    private Map<String, Object> data = null;
}
