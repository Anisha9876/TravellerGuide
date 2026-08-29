package com.travelGuide.GuideWeb.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;


@Service
public class JwtService {
    String secretKey="ddjdnndbndjsskammssmwnchvdudgdjd";

    public String generateToken(String username){
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 1000 * 60 * 60);

        System.out.println("Issued: " + now);
        System.out.println("Expires: " + expiry);
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(getKey(secretKey))
                .compact();


    }
    private SecretKey getKey(String secretKey){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }


    public String extractUsername(String token){

        return Jwts.parser()
                .verifyWith(getKey(secretKey))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }
    public boolean validateToken(String token,String username){
        String name=extractUsername(token);
        return username.equals(name) && !isExpired(token);

    }
    public boolean isExpired(String token){
          Date expire=Jwts.parser()
                .verifyWith(getKey(secretKey))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
            return expire.before(new Date());
    }
}
