package com.loan.CustomException;

public class InvalidApplicantId extends RuntimeException {
	public InvalidApplicantId (String msg) {
		super(msg);
	}

}
