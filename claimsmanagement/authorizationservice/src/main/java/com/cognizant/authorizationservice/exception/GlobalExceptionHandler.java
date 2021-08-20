package com.cognizant.authorizationservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
/**
 *Error messages for the controller class
 */
@RestControllerAdvice
public class GlobalExceptionHandler 
{
	//Exception Method for USER not found
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Error userNotFoundException(UsernameNotFoundException usernameNotFoundException) 
	{
		return new Error(HttpStatus.BAD_REQUEST,LocalDateTime.now(),usernameNotFoundException.getMessage());
	}
	
	
	//Exception for jwt malfunctioned error
	@ExceptionHandler({MalformedJwtException.class,SignatureException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Error tokenMalformedException() 
	{
		return new Error(HttpStatus.UNAUTHORIZED,LocalDateTime.now(),"Not Authorized --> Token is Invalid..");
	}

}
