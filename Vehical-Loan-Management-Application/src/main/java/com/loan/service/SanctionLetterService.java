package com.loan.service;

import java.util.List;
import java.util.Optional;

import com.loan.model.ApplicantDetails;
import com.loan.model.SanctionLetter;

public interface SanctionLetterService {

public	SanctionLetter saveData(SanctionLetter sanctionLetter);

public Iterable<SanctionLetter> getData();



public List<SanctionLetter> getbystatus(String status);

public SanctionLetter getbyid(Integer sid);

public SanctionLetter sanctionstatuschange(SanctionLetter sanctionLetter);

public SanctionLetter loandisbursestatusinsactionletter(SanctionLetter sanctionLetter);

public ApplicantDetails saveSanctionLetter(ApplicantDetails applicantDetails);

public Optional<ApplicantDetails> findById(int applicantId);

public String sendMailWithAttachment(Integer sid);
 


}
