package com.loan.CustomException;

public class InvalidePanNumber extends RuntimeException {
public InvalidePanNumber (String msg)
{
	super(msg);
}
}
