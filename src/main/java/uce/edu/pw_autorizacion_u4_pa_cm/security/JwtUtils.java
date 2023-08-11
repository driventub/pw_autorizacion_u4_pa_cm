package uce.edu.pw_autorizacion_u4_pa_cm.security;

import java.util.Date;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

    public String generateJWTToken(Authentication authentication, String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+10000)).signWith(SignatureAlgorithm.HS512, "semilla1").compact();
    }
}
