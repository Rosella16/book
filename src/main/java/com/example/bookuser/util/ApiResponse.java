package com.example.bookuser.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiResponse <T> {
    private T payload;
    private HttpStatus status;
    private String message;
    private LocalDateTime date;
    
}
