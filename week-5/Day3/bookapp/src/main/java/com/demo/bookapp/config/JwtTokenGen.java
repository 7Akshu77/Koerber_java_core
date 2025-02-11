package com.demo.bookapp.config;

import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JwtTokenGen {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        String secretKey = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Generated Secret Key: " + secretKey);
    }
}

