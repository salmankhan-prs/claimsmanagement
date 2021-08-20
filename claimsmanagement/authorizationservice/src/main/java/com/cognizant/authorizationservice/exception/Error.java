package com.cognizant.authorizationservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Error {
	    private HttpStatus status;
	    private LocalDateTime timestamp;
	    private String message;
	    
}
