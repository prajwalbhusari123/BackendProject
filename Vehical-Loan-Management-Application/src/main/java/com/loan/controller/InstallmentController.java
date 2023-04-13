package com.loan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.ApplicantDetails;
import com.loan.model.Installments;
import com.loan.model.Ledger;
import com.loan.service.InstallmentServiceInter;

@CrossOrigin("*")
@RestController
public class InstallmentController 
{
		@Autowired
		private InstallmentServiceInter installmentServiceInter;
	
	
		@PutMapping("/saveInstallment/{applicantId}")
		public ResponseEntity<ApplicantDetails> saveInstallment (@RequestBody Installments installments, @PathVariable int applicantId )
		{
			
			Optional<ApplicantDetails> optional = installmentServiceInter.findById(applicantId);
			
			ApplicantDetails applicantDetails = optional.get();
			
			applicantDetails.setInstallments(installments);
			
			ApplicantDetails applicantDetails2 = installmentServiceInter.saveInstallment(applicantDetails);
			
			return new ResponseEntity<ApplicantDetails>(applicantDetails2, HttpStatus.ACCEPTED);
			
			
		}
		
		@GetMapping("/getAllInstallmentDetails")
		public ResponseEntity<List<Installments>> getAllInstallmentDetails()
		{
			
			List<Installments> list = installmentServiceInter.getAllInstallmentDetails();
			
			return new ResponseEntity<List<Installments>>(list, HttpStatus.OK);
			
		}
		
		
		  @GetMapping("/getloanSetteled")
		  public ResponseEntity<List<Installments>> getLedgerDefaulter() {
		  
		  List<Installments> list = installmentServiceInter.getLoansetteled();
		  
		  return new ResponseEntity<List<Installments>>(list,HttpStatus.OK);
		  
		  }
		 
		   
		   
	

}
