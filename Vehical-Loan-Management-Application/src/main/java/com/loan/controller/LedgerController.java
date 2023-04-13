package com.loan.controller;

import java.util.List;
import java.util.Optional;

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

import com.loan.model.ApplicantDetails;
import com.loan.model.Ledger;
import com.loan.service.LedgerIservice;
@CrossOrigin("*")
@RestController
public class LedgerController {
	@Autowired
	LedgerIservice lsi;
	
	//post("http://localhost:9093/saveledgerimfo",ledgerimfo);
   @PostMapping("saveledgerimfo")
	public ResponseEntity<Ledger> postdata(@RequestBody Ledger ledger)
	{
		Ledger ledger1=lsi.postLedgerData(ledger);
		return new ResponseEntity<Ledger>(ledger1, HttpStatus.OK);	
		
	}
   
   
    //this.http.get("http://localhost:9093/getemidata/"+gettostatus);
   @GetMapping("getemidata/{loanStatus}")
   public ResponseEntity<List<Ledger>> getdata(@PathVariable String loanStatus)
	{
	   List<Ledger>list=lsi.getalldata(loanStatus);
	   
		return new ResponseEntity<List<Ledger>>(list, HttpStatus.OK);
	   
	}
	
   //this.http.get("http://localhost:9093/getledgerdata/"+ledgerid)
  @GetMapping("getledgerdata/{ledgerNumber}")
  public ResponseEntity<Ledger> getledgerdata(@PathVariable Integer ledgerNumber)
	{
	   Ledger list=lsi.getledgerdata(ledgerNumber);
		return new ResponseEntity<Ledger>(list, HttpStatus.OK);
	}
  
  @PutMapping("/saveLedger/{applicantId}")
  public ResponseEntity<ApplicantDetails> saveLedger(@RequestBody Ledger ledger, @PathVariable int applicantId) 
  {
	  
	  Optional<ApplicantDetails> optional = lsi.findById(applicantId);
	  
	  ApplicantDetails applicantDetails = optional.get();
	  
	  applicantDetails.setLedger(ledger);
	  
	  
	  
	  ApplicantDetails applicantDetails2 = lsi.saveLedger(applicantDetails);
	  
	  return new ResponseEntity<ApplicantDetails>(applicantDetails2, HttpStatus.OK);
	  
  }
  
  @GetMapping("/getLedgerDetailsByStatus")
  public ResponseEntity<List<Ledger>> getLedgerByStatus()
  {
	  
	  List<Ledger> list = lsi.getLedgerDetails();
	  
	  return new ResponseEntity<List<Ledger>>(list, HttpStatus.OK);
	  
  }
  
  @PutMapping("/updateLedgerForDefaulterCount")
  public ResponseEntity<Ledger> updateLedgerForDefaulter(@RequestBody Ledger ledger)
  {
	  
	  Ledger ledger2 = lsi.updateLedger(ledger);
	  
	  return new ResponseEntity<Ledger>(ledger2, HttpStatus.ACCEPTED);
	  
  }
 
  @GetMapping("/getLedgerDefaulter")
  public ResponseEntity<List<Ledger>> getLedgerDefaulter()
  {
	  
	  List<Ledger> list = lsi.getLedgerDefaulter();
	  
	  return new ResponseEntity<List<Ledger>>(list, HttpStatus.OK);
	  
  }
   
   
   
}
