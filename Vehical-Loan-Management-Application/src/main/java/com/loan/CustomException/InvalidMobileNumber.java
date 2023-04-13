package com.loan.CustomException;

public class InvalidMobileNumber extends RuntimeException{
public  InvalidMobileNumber(String msg) {
	super(msg);
}
}
