package com.doctor.doctorsappointment.doctorlogin.repositories;

import com.doctor.doctorsappointment.doctorlogin.models.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, BigInteger> {
    List<DoctorDetails> findAll();
}
