package com.sign.SIgnUp.Service;

import com.sign.SIgnUp.DTO.LogIn;
import com.sign.SIgnUp.DTO.SignUpDTO;
import com.sign.SIgnUp.Response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {

    String adddata(SignUpDTO signUpDTO);


    LoginResponse loginemployee(LogIn login);
}
