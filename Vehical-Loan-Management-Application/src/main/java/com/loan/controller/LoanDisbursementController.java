package com.loan.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.LoanDisbursement;
import com.loan.service.LoanDisbursementService;

@CrossOrigin("*")
@RestController
public class LoanDisbursementController {
	
	@Autowired
	LoanDisbursementService loanDisbursementService;
	
	//http.post("http://localhost:9093/savedisbursementdata",disburementdata);
	@PostMapping("/savedisbursementdata")
	public ResponseEntity<LoanDisbursement> saveLoanDisbursementdata(@RequestBody LoanDisbursement loanDisbursement){
		loanDisbursementService.saveLoanDisbursement(loanDisbursement);
		return new ResponseEntity<LoanDisbursement>(loanDisbursement,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getloanDisbursedata/{loanDisbursementStatus}")
	public ResponseEntity<List<LoanDisbursement>> getLoanDisburseData(@PathVariable String loanDisbursementStatus){
		List<LoanDisbursement> getdisburedata=loanDisbursementService.getLoanDisburse(loanDisbursementStatus);
		return new ResponseEntity<List<LoanDisbursement>>(getdisburedata,HttpStatus.OK);
	}


}
