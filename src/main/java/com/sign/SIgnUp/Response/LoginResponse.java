package com.sign.SIgnUp.Response;

public class LoginResponse {

    String massage;
    Boolean status;

    public LoginResponse(String massage, Boolean status) {
        this.massage = massage;
        this.status = status;
    }

    public LoginResponse() {
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "massage='" + massage + '\'' +
                ", status=" + status +
                '}';
    }
}
