package com.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loan.model.ApplicantDetails;
import com.loan.model.EmailId;
import com.loan.model.SanctionLetter;
import com.loan.service.EmailService;
@CrossOrigin("*")
@RestController
public class EmailController {

	@Autowired
	EmailService service;

	@PostMapping("/sendMail/{enquiryId}")
	public ResponseEntity<String> sendSimpleMail(@PathVariable int enquiryId) {
		return new ResponseEntity<String>(service.sendSimpleMail(enquiryId), HttpStatus.OK);
	}

	//http.post("http://localhost:9093/sendrejectMail/"+enquiry.enquiryId,enquiry);
	@PostMapping("/sendrejectMail/{enquiryId}")
	public ResponseEntity<String> sendRejectMail(@PathVariable int enquiryId) {
		return new ResponseEntity<String>(service.sendRejectMail(enquiryId), HttpStatus.OK);
	}
	
	
	
	/*
	 * @PostMapping("/mailWithAttachment/{sid}") public ResponseEntity<String>
	 * sendMailWithAttachment(@RequestPart MultipartFile attachment,
	 * 
	 * @PathVariable int sid) // @RequestPart String mailJson,) { return new
	 * ResponseEntity<String>(service.sendMailWithAttachment(attachment, sid),
	 * HttpStatus.OK);// mailJson }
	 */

//	return this.http.post("http://localhost:9093/sendsanctionmail/"+sanctiondata.sid,sanctiondata);
	@PostMapping("/sendsanctionmail/{sid}")
	public ResponseEntity<String> sanctionmail(@PathVariable int sid, @RequestBody SanctionLetter sanctionLetter) {
		return new ResponseEntity<String>(service.sanctionmail(sid,sanctionLetter), HttpStatus.OK);
	}
	

	
}
