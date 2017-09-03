package com.immediateactiongroup.issues.utils;

import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.commons.exception.TokenException;
import com.immediateactiongroup.issues.security.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/1 下午4:28
 * jwt utils
 */
@Component
public class JwtUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstant.TOKEN_USERNAME, userDetails.getUsername());
        return generateToken(claims);
    }
    /**
     * 生成Token
     * generate token
     * @param claims
     * @return
     */
    public String generateToken(Map<String, Object> claims){
        LOGGER.debug("【Jwt】 生成Token");
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, generateKey())
                .compact();
    }


    public Claims getClaimsFromToken(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(generateKey())
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            LOGGER.error("【Jwt】illegal token......");
        }
        return claims;
    }

    public boolean canRefreshToken(String token){
        return !isTokenExpired(token);
    }

    public String refreshToken(String token){
        String refreshToken;

        final Claims claims = getClaimsFromToken(token);
        refreshToken = generateToken(claims);

        return refreshToken;
    }

    /**
     * 验证token是否有效性
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails){
        final Claims claims = getClaimsFromToken(token);
        if(claims != null) {
            final String username = claims.getSubject();
            return username.equals(userDetails.getUsername()) &&
                    !this.isTokenExpired(token);
        }
        return false;
    }

    /**
     * 验证Token是否过期
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 从Token中获取过期时间
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token){
        Date expiration = null;
        final Claims claims = getClaimsFromToken(token);
        if(claims != null) {
            try {
                expiration = claims.getExpiration();
            } catch (Exception e) {
                LOGGER.error("【Jwt】 获取过期时间失败");
            }
        }
        return expiration;
    }

    /**
     * 从Token中获取用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token){
        String username = null;
        Claims claims = getClaimsFromToken(token);
        if(claims != null){
            username = claims.getSubject();
        }
        return username;
    }

    /**
     * 生成key
     * @return
     */
    private SecretKey generateKey(){
        //byte [] encodeKey = Base64.encodeBase64(JwtConstant.SECRET_PRIMARY_KEY.getBytes());
        byte [] encodeKey = JwtConstant.SECRET_PRIMARY_KEY.getBytes();
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    /**
     * 生成过期时间
     * @return
     */
    private Date generateExpirationDate(){
        long nowTime = System.currentTimeMillis();
        Calendar.Builder builder = new Calendar.Builder();
        builder.setInstant(nowTime + JwtConstant.OUTOFTIME);
        return builder.build().getTime();
    }
}
