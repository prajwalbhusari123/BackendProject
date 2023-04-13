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
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addrId;	
    private Integer pinCode;  
	private String areaName;	
	private String cityName;	
	private String stateName;	
	

}
