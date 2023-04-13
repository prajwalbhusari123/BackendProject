package com.loan.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.model.ApplicantDetails;
import com.loan.model.Ledger;
import com.loan.repository.ApplicantDetailsRepository;
import com.loan.repository.LedgerRepository;
import com.loan.service.LedgerIservice;
@Service
public class LedgerServiceImpl implements LedgerIservice{
@Autowired
LedgerRepository lr;

@Autowired
ApplicantDetailsRepository applicantDetailsRepository;
	
	@Override
	public Ledger postLedgerData(Ledger ledger) {
		ledger.setLoanStatus("emiStart");
	Ledger l=lr.save(ledger);
		return l;
	}
	
	
	@Override
		public List<Ledger> getalldata(String loanStatus) {
		List<Ledger> list=lr.findByLoanStatus(loanStatus);
			return list;
		}


	@Override
	public Ledger getledgerdata(int ledgerNumber) {
		return lr.findByLedgerNumber(ledgerNumber);
	}


	@Override
	public Optional<ApplicantDetails> findById(int applicantId) {

		Optional<ApplicantDetails> optional = applicantDetailsRepository.findByApplicantId(applicantId);
		
		return optional;
	}


	@Override
	public ApplicantDetails saveLedger(ApplicantDetails applicantDetails) {

		applicantDetails.getLedger().setLoanStatus("Active");
		applicantDetails.getLedger().setDefaulterCount(0);
		return applicantDetailsRepository.save(applicantDetails);
	}


	@Override
	public List<Ledger> getLedgerDetails() {

		List<Ledger> list = lr.findAllByLoanStatusOrLoanStatus("Active","Defaulter");
		
		return list;
	}


	@Override
	public Ledger updateLedger(Ledger ledger) {

		ledger.setDefaulterCount(ledger.getDefaulterCount()+1);
		
		if(ledger.getDefaulterCount() >= 3)
		{
			
			ledger.setLoanStatus("Defaulter");
		}
		
		Ledger ledger2 = lr.save(ledger);
		
		
		return ledger2;
	}


	@Override
	public List<Ledger> getLedgerDefaulter() {
		
		return lr.findAllByLoanStatus("Defaulter");
	}

}
