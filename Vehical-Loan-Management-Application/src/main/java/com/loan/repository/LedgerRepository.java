package com.loan.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Ledger;
@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Serializable> {

public	List<Ledger> findByLoanStatus(String loanStatus);

public Ledger findByLedgerNumber(int ledgerNumber);

public List<Ledger> findAllByLoanStatusOrLoanStatus(String string, String string2);

public List<Ledger> findAllByLoanStatus(String status);

}
