package com.dev.videoblogappsecurity.configuration;


import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {


    private final byte[] signinKey;
    private final String SECRET_KEY = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
    private final long tokenValidityInSeconds;


    public JwtProvider(){
        this.signinKey = Decoders.BASE64.decode(SECRET_KEY);
        this.tokenValidityInSeconds=300;
    }


    public String generateToken(String username,String apiKey){

        Claims claims = new DefaultClaims();
        claims.setSubject(username);
        claims.put("api-key",apiKey);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+tokenValidityInSeconds*1000))
                .signWith(Keys.hmacShaKeyFor(signinKey), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token){
        Jws<Claims> claimsJws= Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }

}


