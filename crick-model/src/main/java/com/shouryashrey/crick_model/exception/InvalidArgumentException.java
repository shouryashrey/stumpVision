package com.shouryashrey.crick_model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvalidArgumentException implements Serializable {

    private String message;

    private Map<String, String> errors;

    private LocalDateTime timestamp;
}
