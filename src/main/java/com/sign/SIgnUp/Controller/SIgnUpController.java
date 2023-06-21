package com.sign.SIgnUp.Controller;

import com.sign.SIgnUp.DTO.LogIn;
import com.sign.SIgnUp.DTO.SignUpDTO;
import com.sign.SIgnUp.Response.LoginResponse;
import com.sign.SIgnUp.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/name")
public class SIgnUpController {

    private SignUpService signUpService;

    private SIgnUpController(SignUpService signUpService){
        this.signUpService=signUpService;
    }


    @PostMapping("/save")
    public String saveSignUp(@RequestBody SignUpDTO signUpDTO){
       String id =signUpService.adddata(signUpDTO);
        return "login:"+id;
    }


    @PostMapping("/login")

    public ResponseEntity<?> loginemployee(@RequestBody LogIn login)
    {
        LoginResponse loginResponse = signUpService.loginemployee(login);
        return ResponseEntity.ok(loginResponse);
    }
}
























