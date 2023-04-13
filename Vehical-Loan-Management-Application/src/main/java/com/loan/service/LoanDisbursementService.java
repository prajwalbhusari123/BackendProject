package com.loan.service;

import java.util.List;

import com.loan.model.LoanDisbursement;

public interface LoanDisbursementService {

	void saveLoanDisbursement(LoanDisbursement loanDisbursement);

	List<LoanDisbursement> getLoanDisburse(String loanDisbursementStatus);

}
