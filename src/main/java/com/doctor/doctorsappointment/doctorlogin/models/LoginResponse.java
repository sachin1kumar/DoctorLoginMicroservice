package com.doctor.doctorsappointment.doctorlogin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigInteger;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class LoginResponse {
    private BigInteger doctorId;
    private String errorMsg;

    public LoginResponse() {
    }

    public BigInteger getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(BigInteger doctorId) {
        this.doctorId = doctorId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
