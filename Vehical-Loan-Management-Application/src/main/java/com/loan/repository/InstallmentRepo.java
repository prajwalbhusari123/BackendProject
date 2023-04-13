package com.loan.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Installments;
@Repository
public interface InstallmentRepo extends JpaRepository<Installments, Serializable>{

	List<Installments> findAllByInstallmentStatus(String string);

}
