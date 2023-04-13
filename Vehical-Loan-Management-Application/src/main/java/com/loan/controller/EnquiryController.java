package com.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.ApplicantDetails;
import com.loan.model.Enquiry;
import com.loan.service.Enquiryservice;

@CrossOrigin("*")
@RestController
public class EnquiryController {

	@Autowired
	Enquiryservice service;
	
	//http.post<Enquiry>("http://localhost:9093/enquiry",enqui);
	@PostMapping("/enquiry")
	public ResponseEntity<Enquiry> EnquiryApplication(@RequestBody Enquiry enquiry) {
		Enquiry enquiry2 = service.postEnquiryApplication(enquiry);
		return new ResponseEntity<Enquiry>(enquiry2, HttpStatus.CREATED);
	}

	//http.get<Enquiry[]>("http://localhost:9093/enquiry");
	@GetMapping("/enquiry")
	public ResponseEntity<Iterable<Enquiry>> getEnquiryApplication() {
		Iterable<Enquiry> itr = service.getEnquiryApplication();
		return new ResponseEntity<Iterable<Enquiry>>(itr, HttpStatus.OK);
	}

	//http.get("http://localhost:9093/enquiry/"+enqId);
	@GetMapping("/enquiry/{enquiryId}")
	public ResponseEntity<Enquiry> getbyid(@PathVariable Integer enquiryId) {
		Enquiry en = service.getEnquiryApplicationById(enquiryId);
		return new ResponseEntity<Enquiry>(en, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByid/{enquiryId}")
	public ResponseEntity<String> deleteById(@PathVariable Integer enquiryId) {
		service.deleteById(enquiryId);
		return new ResponseEntity<String>("Data Delete Succesfully",HttpStatus.OK);
	}
	
	@GetMapping("/getdata")
	public ResponseEntity<Iterable<Enquiry>> getbyenquiry()
	{
		Iterable<Enquiry>   enq  =service.getcibil();  
		return new ResponseEntity<Iterable<Enquiry>>(enq,HttpStatus.OK);
		
	}
	
	//http.put("http://localhost:9093/getCibibyId/",enquiry);
	@GetMapping("/getCibibyId/{enquiryId}")
	public ResponseEntity<Enquiry> getCibilScoreById(@PathVariable Integer enquiryId){
	Enquiry enquiry=service.getCibilById(enquiryId);
		return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
	}
	
	
//	----------------------
	
	
	//("http://localhost:9093/updateEnquiryCibil/",enquiryId);
	
	@PutMapping("/updateEnquiryCibil")
	public ResponseEntity<Enquiry> updateEnquiryCibil(@RequestBody Enquiry enquiry){
		Enquiry enq=service.updateEnquiryCibil(enquiry);
		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK);
	}
	
	
	//http.get("http://localhost:9093/getCibibyId/"+Id);
	@PutMapping("/getCibibyId")
	public ResponseEntity<Enquiry> updateCibilScore(@RequestBody Enquiry enquiry){
		Enquiry enq=service.updateCibilScore(enquiry);
		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK);
}
	
	//http.put("http://localhost:9093/approvecibilbyoe/",enquiry);
	@PutMapping("/approvecibilbyoe")
	public ResponseEntity<Enquiry> cibilapprovebyoe(@RequestBody Enquiry enquiry){
		Enquiry enq=service.cibilapprovebyoe(enquiry);
		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK);
	
	}
	
	//http.put("http://localhost:9093/rejectcibilbyoe/",enquiry);
	@PutMapping("/rejectcibilbyoe")
	public ResponseEntity<Enquiry> cibilrejectbyoe(@RequestBody Enquiry enquiry){
		Enquiry enq=service.cibilrejectbyoe(enquiry);
		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK);
	}
	
	//http.get("http://localhost:9093/getApprovedbyOE/"+status);
	@GetMapping("/getApprovedbyOE/{enquiryCibilStatus}")
	public ResponseEntity<List<Enquiry>> getApproveByOE(@PathVariable String enquiryCibilStatus){
	List<Enquiry> enquiry=service.getApprovebyOE(enquiryCibilStatus);
		return new ResponseEntity<List<Enquiry>>(enquiry,HttpStatus.OK);
	}
	
}
