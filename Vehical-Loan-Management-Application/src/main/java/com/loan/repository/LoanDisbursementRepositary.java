package com.loan.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.LoanDisbursement;

@Repository
public interface LoanDisbursementRepositary extends JpaRepository<LoanDisbursement, Serializable>{

	List<LoanDisbursement> findByLoanDisbursementStatus(String loanDisbursementStatus);

	
}
