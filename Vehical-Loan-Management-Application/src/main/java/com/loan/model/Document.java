package com.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer	docId;	
@Lob
private String  adharCard;
@Lob
private String 	panCard;
@Lob
private String	cancelledCheque;
@Lob
private String passbook;
@Lob
private String signature;
@Lob
private String photo;
@Lob
private String quotation;	



}
