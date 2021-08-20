package com.cognizant.claimsmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProviderNotFoundException.class)
	public ResponseEntity<String> handleProviderNotFoundException(ProviderNotFoundException providerNotFoundException)
	{
		return new ResponseEntity<String>("No provider is availiable at this provider id",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BenefitsNotFoundException.class)
	public ResponseEntity<String> handleBenefitsNotFoundException(BenefitsNotFoundException benefitsNotFoundException)
	{
		return new ResponseEntity<String>("No benefits are availiable with this benefit id",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ClaimNotFoundException.class)
	public ResponseEntity<String> handleClaimNotFoundException(ClaimNotFoundException claimNotFoundException)
	{
		return new ResponseEntity<String>("No claims are availiable with this details",HttpStatus.BAD_REQUEST);
	}
}
