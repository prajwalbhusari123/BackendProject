package com.loan.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ledger {
	@Id

	private Integer ledgerNumber;
	
	private Integer loanApplicationNumber;
	
	private String ledgerFname;
	
	private String ledgerLname;
	
	@CreationTimestamp
	private Date createDate;
	
	private Double ledgerLoanAmount;
	
	private String loanStatus;
	
	private Double totalPaywithInterest;
	
	private Integer tenure;
	
	private Double monthlyemi;
	
	private Integer defaulterCount;
	
}
