package com.immediateactiongroup.issues.utils;

import io.jsonwebtoken.Claims;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/1 下午5:03
 */
public class JwtUtilsTest {

    @Test
    public void testGenerateToken(){
        Map<String , Object> claims = new HashMap<>();
        claims.put("sub", "xueshan");
        claims.put("nickname", "beishan");
        String token = JwtUtils.generateToken(claims);
        System.out.println(token);

    }

    @Test
    public void testGetClaimsFromToken(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ4dWVzaGFuIiwibmlja25hbWUiOiJiZWlzaGFuIiwiZXhwIjoxNTA0MzIyODYwfQ.FOJq2sJdjhs8ddc4dNF9m4Pr7BxP4e8NGOVU8nnCrSZlJa1ryy4DkpjpuK6gp6WLyPrdFoswRx4LiREmc7sREg";

        Claims claims = JwtUtils.getClaimsFromToken(token);
        String subject = claims.getSubject();

        System.out.println(subject);
    }

    @Test
    public void test() throws Exception{
        byte [] encodeKey = Base64.encodeBase64("beishan雪山".getBytes());
        System.out.println(new String(encodeKey, "utf-8"));
        byte [] decodeKey = Base64.decodeBase64(encodeKey);
        System.out.println(new String(decodeKey, "utf-8"));
    }

}
