package com.loan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoanDisbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanId;
	private Long loanAccountNumber;
	private String loanApplicantFname;
	private String loanApplicantLname;
	private String applicantPanNumber;
	private Double totalDisbursementAmount;
	private Double remainingDisbursementAmount;
	private Double totalSanctionLoanAmount;
	private String loanDisbursementStatus;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private CarDealerDetails carDealerDetails;

}
