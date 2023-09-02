package uce.edu.pw_autorizacion_u4_pa_cm.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    private static final Logger LOG=LoggerFactory.getLogger(JwtUtils.class);

    // @Value("${app.jwt.secret}")
    // private String jwtSecret;

    // @Value("${app.jwt.expiration.ms}")
    // private Integer jwtExpiration;

    // Esta es la parte donde edito, para que en el controller reciba esos parametros
    public String generateJWTToken( String username, String jwtSecret, Integer jwtExpiration) {

        LOG.info("Semilla: " + jwtSecret + " Tiempo: " + jwtExpiration);

        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

    }

    

}
