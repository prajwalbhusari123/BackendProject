package com.loan.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.SanctionLetter;
@Repository
public interface SanctionLetterRepository extends JpaRepository<SanctionLetter,Integer>{

	List<SanctionLetter> findByStatus(String status);

	Optional<SanctionLetter> findBySid(Integer sid);


}
