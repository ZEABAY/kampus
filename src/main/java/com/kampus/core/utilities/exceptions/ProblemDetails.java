package com.kampus.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    private int status;
    private String statusDescription;
    private LocalDateTime timestamp;
    private String message;
}