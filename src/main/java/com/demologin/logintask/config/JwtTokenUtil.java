package com.demologin.logintask.config;

import com.demologin.logintask.service.LoginJwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtTokenUtil implements LoginJwt {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String generateToken(String reqEmail) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, reqEmail);
    }
    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
}
