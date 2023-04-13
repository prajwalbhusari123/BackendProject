package com.loan.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Serializable> {

	 public Optional<Enquiry> findByEnquiryId(Integer enquiryid);

	public List<Enquiry> findByEnquiryCibilStatus(String string);
}
