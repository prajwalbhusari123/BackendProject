package com.loan.ExceptionHandeller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loan.CustomException.EmailIdnotfound;
import com.loan.CustomException.InvalidApplicantId;
import com.loan.CustomException.InvalidMobileNumber;
import com.loan.CustomException.InvalidePanNumber;
import com.loan.model.Enquiry;

@RestControllerAdvice
public class GlobalExceptions {
	@ExceptionHandler(value=InvalidMobileNumber.class)
	public ResponseEntity<String>mobno(){
		return new ResponseEntity<String>("Invalid Mobile Number...Please Enter Again!!", HttpStatus.OK);
				
	}
	@ExceptionHandler(value=EmailIdnotfound.class)
	public ResponseEntity<String>mail(){
		return new ResponseEntity<String>("Invalid Email ID...Please Enter Again!!", HttpStatus.OK);
				
	}
 
	@ExceptionHandler(value=InvalidApplicantId.class)
	public ResponseEntity<String>applicantId(){
		return new ResponseEntity<String>("Invalid ApplicantId...Please Enter Again!!", HttpStatus.OK);
				
	}
	@ExceptionHandler(value=InvalidePanNumber.class)
	public ResponseEntity<String>applicationPanno(){
		return new ResponseEntity<String>("Invalid Applicantpannumber...Please Enter Again!!", HttpStatus.OK);
				
	}
}

