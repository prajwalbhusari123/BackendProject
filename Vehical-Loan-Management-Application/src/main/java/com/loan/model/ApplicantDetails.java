package com.loan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApplicantDetails
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicantId;	
	private Integer applicantCibilScore;
	private String applicantFname;	
	private String applicantLname;	
	private Long applicantMobNumber;	
	private String applicantEmailId;	
	private String applicantDob;
	private String applicatLoantenure;
	private String applicantOccupation;	
	private Long applicantAdharno;	
	private String applicationPanno;	
	private Float applicantLoanAmount;	
	private String applicantStatus;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private BankDetails bankdetails;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Document document;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private VehicleDetails vehicaldetail;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private SanctionLetter sanctionLetter;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Ledger ledger;
	
	@OneToOne(cascade =CascadeType.ALL)
	private Installments installments;
	
	
//	  @Lob private byte[] pdf;
	 

}
