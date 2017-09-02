package com.immediateactiongroup.issues.utils;

import com.immediateactiongroup.issues.security.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/1 下午4:28
 * jwt utils
 */
public class JwtUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    /**
     * generate token
     * @param claims
     * @return
     */
    public static String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, generateKey())
                .compact();
    }


    public static Claims getClaimsFromToken(String token){
        Claims claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(generateKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e){

            claims = null;
            LOGGER.error("【Jwt】token 解析出错....(parse token has a error)");
        }

        return claims;
    }


    public static boolean validateToken(String token, UserDetails userDetails){

        return false;
    }

    public static String getUsernameFromToken(String token){
        String username;
        Claims claims = getClaimsFromToken(token);
        username = claims.getSubject();
        return username;
    }

    private static SecretKey generateKey(){
        byte [] encodeKey = Base64.encodeBase64(JwtConstant.SECRET_PRIMARY_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    private static Date generateExpirationDate(){
        long nowTime = System.currentTimeMillis();
        Calendar.Builder builder = new Calendar.Builder();
        builder.setInstant(nowTime + JwtConstant.OUTOFTIME);
        return builder.build().getTime();
    }
}
