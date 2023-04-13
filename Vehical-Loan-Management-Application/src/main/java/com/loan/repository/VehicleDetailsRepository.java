package com.loan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.VehicleDetails;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Serializable>{

}
