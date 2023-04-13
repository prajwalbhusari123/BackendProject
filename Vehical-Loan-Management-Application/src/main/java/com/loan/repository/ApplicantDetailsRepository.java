package com.loan.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.ApplicantDetails;
@Repository
public interface ApplicantDetailsRepository extends JpaRepository<ApplicantDetails, Serializable>{
//public ApplicantDetails findByApplicantId(Integer applicantId);

public Optional<ApplicantDetails> findByApplicantId(Integer applicantId);
public Optional<ApplicantDetails> findByApplicationPanno(String applicationPanno);
public Optional<ApplicantDetails> deleteByApplicantId(Integer applicantId);
public List<ApplicantDetails> findByApplicantStatus(String applicantStatus);

}