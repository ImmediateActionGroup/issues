package com.immediateactiongroup.issues.utils;

import com.immediateactiongroup.issues.security.JwtUser;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/1 下午5:03
 */
public class JwtUtilsTest {
    private JwtUtils jwtUtils;
    @Before
    public void before(){
        jwtUtils = new JwtUtils();
    }
    @Test
    public void testGenerateToken(){
        Map<String , Object> claims = new HashMap<>();
        claims.put("sub", "xueshan");
        claims.put("nickname", "beishan");
        String token = jwtUtils.generateToken(claims);
        System.out.println(token);

    }

    @Test
    public void testGetClaimsFromToken(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ4dWVzaGFuIiwibmlja25hbWUiOiJiZWlzaGFuIiwiZXhwIjoxNTA0NDAyMTU3fQ._D8I9vcE98Gvn1SbN8xVJpSAws1HguxeDjv_s6UdxXeF2MjbVwmcrFB6IpPTk2zyWlWfOq5yCu95lQy9VdRIsA";
        //Claims claims = jwtUtils.getClaimsFromToken(token);
        String subject = jwtUtils.getUsernameFromToken(token);

        System.out.println(subject);
    }

    @Test
    @Ignore
    public void test() throws Exception{
        byte [] encodeKey = Base64.encodeBase64("beishan雪山".getBytes());
        System.out.println(new String(encodeKey, "utf-8"));
        byte [] decodeKey = Base64.decodeBase64(encodeKey);
        System.out.println(new String(decodeKey, "utf-8"));
    }

    public void test1(){

    }

}

class Demo{
    private  int hash;
}
