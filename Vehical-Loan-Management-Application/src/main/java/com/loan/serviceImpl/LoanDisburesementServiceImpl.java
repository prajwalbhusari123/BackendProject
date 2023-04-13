package com.loan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.model.LoanDisbursement;
import com.loan.repository.LoanDisbursementRepositary;
import com.loan.service.LoanDisbursementService;


@Service
public class LoanDisburesementServiceImpl implements LoanDisbursementService{
	
	@Autowired
	LoanDisbursementRepositary loanDisbursementRepositary;

	@Override
	public void saveLoanDisbursement(LoanDisbursement loanDisbursement) {
		loanDisbursement.setLoanDisbursementStatus("LoanDisburse");
		loanDisbursement.setRemainingDisbursementAmount((loanDisbursement.getTotalSanctionLoanAmount())-(loanDisbursement.getTotalDisbursementAmount()));
	loanDisbursementRepositary.save(loanDisbursement);
	}

	@Override
	public List<LoanDisbursement> getLoanDisburse(String loanDisbursementStatus) {
		
		return loanDisbursementRepositary.findByLoanDisbursementStatus(loanDisbursementStatus);
	}
}
