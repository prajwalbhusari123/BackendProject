package com.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer bankId;	
	 private String bankName;	
	 private String bankBranchName;	
	 private Long bankAccountNumber;	
	 private String  bankIFSCCode;	
	 private String bankAddress;	


}
