package com.example.threerivers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class AccountInvalid extends HttpClientErrorException{

	public AccountInvalid(String errorMessage) {
		super(HttpStatus.NOT_FOUND, errorMessage);
	}
}
