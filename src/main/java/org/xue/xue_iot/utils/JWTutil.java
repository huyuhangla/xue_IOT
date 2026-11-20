package org.xue.xue_iot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JWTutil {

    private static final String KEY = "xue123";
    public static String getToken(Map<String,Object> claims){
        /*System.out.println(JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+7*24*60*60*1000))  //过期时间为7天
                .sign(Algorithm.HMAC256(KEY)));*/
        return JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+7*24*60*60*1000))  //过期时间为7天
                .sign(Algorithm.HMAC256(KEY));
    }

    public static Map<String,Object> parseToken(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(KEY)).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("user").asMap();
    }
}
