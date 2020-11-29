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
import java.util.List;

@RestController
@RequestMapping("/authorize")
public class DoctorLoginController {

    @Autowired
    private DoctorDetailsRepository doctorDetailsRepository;

    @RequestMapping(value = "/authorizeDoctor", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> authenticateDoctor(@RequestBody DoctorDetails doctorDetails) {
        String email = doctorDetails.getEmail_id();
        String password = doctorDetails.getPassword();
        List<DoctorDetails> allDoctorDetailsList = doctorDetailsRepository.findAll();
        LoginResponse loginResponse = isDoctorPresent(email, password, allDoctorDetailsList);
        if (loginResponse.getErrorMsg().equalsIgnoreCase("Success")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(loginResponse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
    }

    private LoginResponse isDoctorPresent(String email, String password, List<DoctorDetails> allDoctorDetailsList) {
        LoginResponse loginResponse = new LoginResponse();
        for (DoctorDetails doctorDetails: allDoctorDetailsList) {
            if (doctorDetails.getEmail_id().equalsIgnoreCase(email) &&
                doctorDetails.getPassword().equalsIgnoreCase(password)) {
                loginResponse.setDoctorId(doctorDetails.getId());
                loginResponse.setErrorMsg("Success");
                return loginResponse;
            }
        }
        loginResponse.setErrorMsg("No Doctor exists");
        return loginResponse;
    }
}
