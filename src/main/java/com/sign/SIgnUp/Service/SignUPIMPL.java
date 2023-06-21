package com.sign.SIgnUp.Service;

import com.sign.SIgnUp.DTO.LogIn;
import com.sign.SIgnUp.DTO.SignUpDTO;
import com.sign.SIgnUp.Entity.SIgnUp;
import com.sign.SIgnUp.Repository.SignUpRepository;
import com.sign.SIgnUp.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUPIMPL implements  SignUpService{

  @Autowired
  private SignUpRepository signUprepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

    @Override
    public String adddata(SignUpDTO signUpDTO) {

        SIgnUp sign = new SIgnUp(

                signUpDTO.getId(),
                signUpDTO.getName(),
                signUpDTO.getEmail(),
           this.passwordEncoder.encode(signUpDTO.getPassword())
        );
        signUprepo.save(sign);
        return sign.getName();

    }

    @Override
    public LoginResponse loginemployee(LogIn login) {

        String msg = "";
        
        SIgnUp sign1 = signUprepo.findByEmail(login.getEmail());
        if (sign1 != null) {
            String password = login.getPassword();
            String encodedPassword = sign1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<SIgnUp> si = signUprepo.findOneByEmailAndPassword(login.getEmail(),encodedPassword );
                if (si.isPresent() ){
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }

    }
}
