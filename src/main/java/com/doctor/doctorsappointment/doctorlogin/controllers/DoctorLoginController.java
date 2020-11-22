package com.doctor.doctorsappointment.doctorlogin.controllers;

import com.doctor.doctorsappointment.doctorlogin.models.DoctorDetails;
import com.doctor.doctorsappointment.doctorlogin.models.LoginResponse;
import com.doctor.doctorsappointment.doctorlogin.repositories.DoctorDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorize")
public class DoctorDetailsController {

    @Autowired
    private DoctorDetailsRepository doctorDetailsRepository;

    @RequestMapping(value = "/authorizeDoctor", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> authenticateDoctor(@RequestBody DoctorDetails doctorDetails) {
            doctorDetailsRepository.save(doctorDetails);
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setDoctorId(doctorDetails.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(loginResponse);
    }



}
