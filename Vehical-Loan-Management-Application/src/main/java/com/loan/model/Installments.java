package com.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Installments {
	
	@Id
	
	private Integer installmentId;
	private Long loanAccountNumber; 	//patch from Loan Disbursee  FE
	private String emiRecivedDate;		//frontEnd Date format		FE
	private int installmentNumber;	//Manually FroontEnd		FE
	private Double monthlyEmiAmount;	//Patch from Loan Dis		FE	

	private Integer totalNumberOfEmis;	//BackEnd Auto Generate		BE
	private Integer numberOfEmiRecived;	//BackEnd Logic of Increment	BE
	private Integer numberOfEmiRemaining;	//Backend Logic total - recived  BE
	private String nextEmiDueDate;			//logic FrontEnd		FE
	private Integer loanTenureInYears;		//Patch from Laon Disburse  FE
	private String installmentStatus;		//Back End Automatic  BE
	private Double totalRemaningLoanAmountToBePaid;
	

}
