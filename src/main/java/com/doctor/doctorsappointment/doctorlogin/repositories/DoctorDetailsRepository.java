package com.doctor.doctorregistration.repositories;

import com.doctor.doctorregistration.models.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, BigInteger> {
}
