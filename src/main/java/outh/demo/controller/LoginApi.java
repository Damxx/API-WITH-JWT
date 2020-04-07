package outh.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApi {

}


/*

    Diffrent Way to generate token

    @PostMapping("/login")
    public String login(@RequestBody UserApplication userApplication){
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(userApplication.getUsername())
                .claim("roles","user")
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 200000))
                .signWith(SignatureAlgorithm.HS512, userApplication.getPassword())
                .compact();

    }*/
