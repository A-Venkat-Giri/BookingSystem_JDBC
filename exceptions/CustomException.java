package com.bbs.exceptions;

public class CustomException extends RuntimeException{

	public CustomException(String string)
	{
		System.err.println(string);
	}
}
