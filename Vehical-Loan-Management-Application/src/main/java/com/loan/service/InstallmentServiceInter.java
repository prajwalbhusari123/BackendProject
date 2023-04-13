package com.loan.service;

import java.util.List;
import java.util.Optional;

import com.loan.model.ApplicantDetails;
import com.loan.model.Installments;

public interface InstallmentServiceInter {

	Optional<ApplicantDetails> findById(int applicantId);

	ApplicantDetails saveInstallment(ApplicantDetails applicantDetails);

	List<Installments> getAllInstallmentDetails();
	
	  List<Installments> getLoansetteled();
	 

}
