package com.loan.service;

import java.util.List;
import java.util.Optional;

import com.loan.model.ApplicantDetails;
import com.loan.model.Ledger;

public interface LedgerIservice {

public	Ledger postLedgerData(Ledger ledger);

public List<Ledger> getalldata(String loanStatus);

public Ledger getledgerdata(int ledgerNumber);

public Optional<ApplicantDetails> findById(int applicantId);

public ApplicantDetails saveLedger(ApplicantDetails applicantDetails);

public List<Ledger> getLedgerDetails();

public Ledger updateLedger(Ledger ledger);

public List<Ledger> getLedgerDefaulter();


}
