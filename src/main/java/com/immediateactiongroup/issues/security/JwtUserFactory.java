package com.immediateactiongroup.issues.security;

import com.immediateactiongroup.issues.model.User;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午4:57
 */
public final class JwtUserFactory {
    private JwtUserFactory(){

    }

    public static JwtUser create(User user){
        return new JwtUser(user.getId(),
                user.getNickname(),
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities());
    }
}
