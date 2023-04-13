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
public class DealerAccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer did;
	private String dealerAccHolderName;
	private String dealerAccBankName;
	private String dealerAccountNumber;
	private String dealerBranchName;
	private String dealerBankIFSCCode;

}
