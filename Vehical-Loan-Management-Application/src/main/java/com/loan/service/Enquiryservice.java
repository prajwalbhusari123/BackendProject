package com.loan.service;


import java.util.List;

import com.loan.model.Enquiry;

public interface Enquiryservice {

	public Enquiry postEnquiryApplication( Enquiry enquiry);
	public Iterable<Enquiry>getEnquiryApplication();
	public Enquiry getEnquiryApplicationById( Integer enquiryId);
	public void deleteById(Integer enquiryId);
	public Iterable<Enquiry> getcibil();
	public Enquiry getCibilById(Integer enquiryId);
	public Enquiry updateEnquiryCibil(Enquiry enquiry);
	public Enquiry updateCibilScore(Enquiry enquiry);
	public Enquiry cibilapprovebyoe(Enquiry enquiry);
	public List<Enquiry> getApprovebyOE(String enquiryCibilStatus);
	public Enquiry cibilrejectbyoe(Enquiry enquiry);

	
	

	
	
	
}


