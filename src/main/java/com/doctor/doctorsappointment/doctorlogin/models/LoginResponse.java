package com.doctor.doctorsappointment.doctorlogin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RegistrationResponse {
    private BigInteger doctorId;

    public RegistrationResponse() {
    }

    public BigInteger getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(BigInteger doctorId) {
        this.doctorId = doctorId;
    }
}
