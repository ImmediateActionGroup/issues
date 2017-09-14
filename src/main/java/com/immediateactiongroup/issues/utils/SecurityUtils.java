package com.immediateactiongroup.issues.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午4:20
 */
public class SecurityUtils {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encode(String source){
        return encoder.encode(source);
    }
}
