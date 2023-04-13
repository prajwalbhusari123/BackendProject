package com.loan.model;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.aop.interceptor.SimpleTraceInterceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarDealerDetails {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer cardealerid;
	private String dealerName;
	private String dealerAddress;
	private String dealerEmail;
	private Long dealerMobileNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private DealerAccountDetails dealerAccountDetails;

}
