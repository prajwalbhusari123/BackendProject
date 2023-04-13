package com.loan.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanctionLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	
    @CreationTimestamp
	private Date sanctionDate;
    
	private Integer loanApplicatioNumber;
	private String applicantFname;
	private String applicantLname;
	private String applicantEmailId;
	private String applicantMobNumber;
	private String applicationPanno;
	private String applicantLoanAmount;
	private double loanAmountSanctioned;
	private double rateOfInterest;
	private double loanTenure;
	private double monthlyEmiAmount;
	private String modeOfPayment;
	private String remark;
	private String status;
	
	  @Lob 
	  private byte[] pdfDocument;
	 
}
