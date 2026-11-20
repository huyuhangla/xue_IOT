package org.xue.xue_iot;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GetJWT_test {
    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("user", "xue");
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+7*24*60*60*1000))  //过期时间为7天
                .sign(Algorithm.HMAC256("xue123"));
        System.out.println(token);
    }

    @Test
    public void ParseJWT_test() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXIiOiJ4dWUifSwiZXhwIjoxNzk1NTAyMzkxfQ._tHjMZyDmijEXlk7eSpsQVzebmy89XINyP5AHl7DP0s";
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("xue123")).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("user"));
    }
}

