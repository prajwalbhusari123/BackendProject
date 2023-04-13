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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.ApplicantDetails;
import com.loan.model.SanctionLetter;
import com.loan.service.SanctionLetterService;
@CrossOrigin("*")
@RestController
public class SanctionLetrerController {
	@Autowired
	SanctionLetterService sanctionLetterService;
	
	//http.post("http://localhost:9093/savesanletter",sanletter);
	@PostMapping("/savesanletter")
	public ResponseEntity<SanctionLetter> postData(@RequestBody SanctionLetter sanctionLetter)
	{
		SanctionLetter sl=sanctionLetterService.saveData(sanctionLetter);
		return new ResponseEntity<SanctionLetter>(sl, HttpStatus.CREATED);
		
	}
	@GetMapping("/getData")
	public ResponseEntity<Iterable<SanctionLetter>>getData()
	{
		
		Iterable<SanctionLetter>sanctionLetter=sanctionLetterService.getData();
		return new ResponseEntity<Iterable<SanctionLetter>>(sanctionLetter, HttpStatus.OK);
		
		
	}
	@GetMapping("/getidforsanct/{sid}")
	public ResponseEntity<SanctionLetter> getbyid(@PathVariable Integer sid)
	{
		SanctionLetter sanction=sanctionLetterService.getbyid(sid);
		
		return new ResponseEntity<SanctionLetter> (sanction,HttpStatus.OK);
		
	}
	
	//  return this.http.get("http://localhost:9093/getbySantionLetterSatatus");
	@GetMapping("/getbySantionLetterSatatus/{status}")
	public ResponseEntity<List<SanctionLetter>> getbystatus(@PathVariable String status)
	{
		List<SanctionLetter> applicantsanction=sanctionLetterService.getbystatus(status);
		
		return new ResponseEntity<List<SanctionLetter>>(applicantsanction, HttpStatus.OK);
	}
	
	
	//http.put("http://localhost:9093/sanctionstatuschange/",sanctionstatus);
	@PutMapping("/sanctionstatuschange")
	public ResponseEntity<SanctionLetter> sanctionstatuschange(@RequestBody SanctionLetter sanctionLetter) {
		SanctionLetter sanctionsend=sanctionLetterService.sanctionstatuschange(sanctionLetter);
		return new ResponseEntity<SanctionLetter>(sanctionsend, HttpStatus.OK);
	
	}
	
	//return this.http.put("http://localhost:9093/loandisbursestatusinsactionletter/",sanctiondata);
	@PutMapping("/loandisbursestatusinsactionletter")
	public ResponseEntity<SanctionLetter> loandisbursestatusinsactionletter(@RequestBody SanctionLetter sanctionLetter) {
		SanctionLetter sanctionsend=sanctionLetterService.loandisbursestatusinsactionletter(sanctionLetter);
		return new ResponseEntity<SanctionLetter>(sanctionsend, HttpStatus.OK);
	
	}
	
	@PutMapping("/saveSanctionLetter/{applicantId}")
	public ResponseEntity<ApplicantDetails> saveSanctionLetter(@RequestBody SanctionLetter letter,@PathVariable int applicantId )
	{
		Optional<ApplicantDetails> findByIdOptional = sanctionLetterService.findById(applicantId);
		
		ApplicantDetails applicantDetails = findByIdOptional.get();
		 applicantDetails.setSanctionLetter(letter);
		 
		 ApplicantDetails applicantDetails2 = sanctionLetterService.saveSanctionLetter(applicantDetails);
		 return new ResponseEntity<ApplicantDetails> (applicantDetails2,HttpStatus.OK);
		
	}
	@PostMapping("/mailWithAttachment/{sid}")
	public ResponseEntity<String> sendMailWithAttachment(@PathVariable Integer sid) {
		return new ResponseEntity<String>(sanctionLetterService.sendMailWithAttachment(sid), HttpStatus.OK);
	}
	
}
