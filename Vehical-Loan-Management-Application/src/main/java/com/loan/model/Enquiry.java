package com.loan.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String enquiryFname;
	private String enquiryLname;
	private String enquiryMobnumber;
	private String enquiryEmailid;
	private String enquiryLoanAmount;
	private String enquiryLoantenure;
	private String enquiryPanno;
	private Integer enquiryCibilScore;
	private String enquiryCibilStatus;
	@CreationTimestamp
	private Date enqyiryCreationtime;
	@UpdateTimestamp
	private Date enquryUpdatetime;
	
}