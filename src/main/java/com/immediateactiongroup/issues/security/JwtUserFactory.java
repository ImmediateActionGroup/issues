package com.immediateactiongroup.issues.security;

import com.immediateactiongroup.issues.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午4:57
 */
public final class JwtUserFactory {
    private JwtUserFactory(){

    }

    public static JwtUser create(User user, Collection<? extends GrantedAuthority> authorities){
        return new JwtUser(user.getId(),
                user.getNickname(),
                user.getUsername(),
                user.getPassword(),
                authorities);
    }
}
