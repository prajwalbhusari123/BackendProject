package com.loan.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.loan.model.ApplicantDetails;

public interface ApplicantDetailsService {

	

	public ApplicantDetails saveDocumentDetail(MultipartFile adharCard, MultipartFile panCard,
			MultipartFile cancelledCheque, MultipartFile passbook, MultipartFile signature, MultipartFile photo,
			MultipartFile quotation, String applicationJson);

	public Iterable<ApplicantDetails> getDocumentDetails();

	public ApplicantDetails getDocumentById(Integer applicantId);

	public ApplicantDetails findByApplicantpanno(String applicationPanno);


	public ApplicantDetails updateDocument(MultipartFile adharCard, MultipartFile panCard,
			MultipartFile cancelledCheque, MultipartFile passbook, MultipartFile signature, MultipartFile photo,
			MultipartFile quotation, String applicationJson);


	public void deleteData(int applicantId);


	public ApplicantDetails updateStatus(ApplicantDetails applicant);

	public List<ApplicantDetails> getwaitingforapproval(String applicantStatus);

	public ApplicantDetails verifystatusbyoe(ApplicantDetails applicant);

	public List<ApplicantDetails> getApprovebyOE(String applicantStatus);

	public ApplicantDetails rejectbyoe(ApplicantDetails applicant);

	

}
