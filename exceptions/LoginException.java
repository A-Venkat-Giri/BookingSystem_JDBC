package com.bbs.exceptions;

public class LoginException extends RuntimeException{

	public LoginException(String string)
	{
		System.err.println(string);
	}
}
