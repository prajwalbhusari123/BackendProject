package com.loan.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loan.model.ApplicantDetails;
import com.loan.model.Enquiry;
import com.loan.service.ApplicantDetailsService;
import com.loan.service.servicei;
@CrossOrigin("*")
@RestController
public class ApplicantDetailsController {
	@Autowired
	ApplicantDetailsService applicantDetailsService;
//applicant Details save
	@PostMapping(value = "/savedocument", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json")
	public ResponseEntity<ApplicantDetails> saveDocumentdetails(@RequestPart MultipartFile adharCard,
			@RequestPart MultipartFile panCard, @RequestPart MultipartFile cancelledCheque,
			@RequestPart MultipartFile passbook, @RequestPart MultipartFile signature, @RequestPart MultipartFile photo,
			@RequestPart MultipartFile quotation, @RequestPart String applicationJson) throws IOException {
		ApplicantDetails dd = applicantDetailsService.saveDocumentDetail(adharCard, panCard, cancelledCheque, passbook,
				signature, photo, quotation, applicationJson);
		return new ResponseEntity<>(dd, HttpStatus.CREATED);

	}
	//applicant Details get
	@GetMapping("/getdocument")
	public ResponseEntity<Iterable<ApplicantDetails>> getDocumentDetails() {

		Iterable<ApplicantDetails> adr = applicantDetailsService.getDocumentDetails();

		return new ResponseEntity<Iterable<ApplicantDetails>>(adr, HttpStatus.OK);

	}
	//applicant Details get by ID
	@GetMapping("/getdocumentbyid/{applicantId}")
	public ResponseEntity<ApplicantDetails> getDocumentDetailsById(@PathVariable Integer applicantId) {
		ApplicantDetails app = applicantDetailsService.getDocumentById(applicantId);

		return new ResponseEntity<ApplicantDetails>(app, HttpStatus.OK);

	}
	//applicant Details get by PAN
	@GetMapping("/getdocument/{applicationPanno}")
	public ResponseEntity<ApplicantDetails> getDocumentDetailsByPanno(@PathVariable String applicationPanno) {
		ApplicantDetails app = applicantDetailsService.findByApplicantpanno(applicationPanno);

		return new ResponseEntity<ApplicantDetails>(app, HttpStatus.OK);

	}
	//applicant Details UPDATE
	@PutMapping("/updatedocument/{applicantId}")
	public ResponseEntity<ApplicantDetails> updateDocumentDetails(@PathVariable int applicantId,
			@RequestPart MultipartFile adharCard, @RequestPart MultipartFile panCard,
			@RequestPart MultipartFile cancelledCheque, @RequestPart MultipartFile passbook,
			@RequestPart MultipartFile signature, @RequestPart MultipartFile photo,
			@RequestPart MultipartFile quotation, @RequestPart String applicationJson) {
		ApplicantDetails app = applicantDetailsService.updateDocument(adharCard, panCard, cancelledCheque, passbook,
				signature, photo, quotation, applicationJson);

		return new ResponseEntity<ApplicantDetails>(app, HttpStatus.OK);
	}
	//applicant Details DELETE
	@DeleteMapping("/deletebyid/{applicantId}")

	public String deleteData(@PathVariable("applicantId") int applicantId) {
		applicantDetailsService.deleteData(applicantId);
		return "delete record successfully";

	}
	//applicant Details Change status
	@PutMapping("/updatestatus")
	public ResponseEntity<ApplicantDetails> updateStatus(@RequestBody ApplicantDetails applicant) {
		ApplicantDetails update=applicantDetailsService.updateStatus(applicant);
		return new ResponseEntity<ApplicantDetails>(update, HttpStatus.OK);
	}
	
	@GetMapping("/getwaitingforApproval/{applicantStatus}")
	public ResponseEntity<List<ApplicantDetails>> getWaitingforApproval(@PathVariable String applicantStatus){
		List<ApplicantDetails> applicant=applicantDetailsService.getwaitingforapproval(applicantStatus);
		return new ResponseEntity<List<ApplicantDetails>>(applicant,HttpStatus.OK);
	}
	
	@PutMapping("/verifystatusbyoe")
	public ResponseEntity<ApplicantDetails> verifystatusbyoe(@RequestBody ApplicantDetails applicant) {
		ApplicantDetails update=applicantDetailsService.verifystatusbyoe(applicant);
		return new ResponseEntity<ApplicantDetails>(update, HttpStatus.OK);
	}
	
	@GetMapping("/verifiedapplication/{applicantStatus}")
	public ResponseEntity<List<ApplicantDetails>> verifiedApplicationbyoe(@PathVariable String applicantStatus){
		List<ApplicantDetails> verifyapplication=applicantDetailsService.getApprovebyOE(applicantStatus);
			return new ResponseEntity<List<ApplicantDetails>>(verifyapplication,HttpStatus.OK);
	
	}
	
//	http.put("http://localhost:9093/rejectbyoe/",applicantstatus);
	@PutMapping("/rejectbyoe")
	public ResponseEntity<ApplicantDetails> rejectbyoe(@RequestBody ApplicantDetails applicant) {
		ApplicantDetails reject=applicantDetailsService.rejectbyoe(applicant);
		return new ResponseEntity<ApplicantDetails>(reject, HttpStatus.OK);
	
	}
}
