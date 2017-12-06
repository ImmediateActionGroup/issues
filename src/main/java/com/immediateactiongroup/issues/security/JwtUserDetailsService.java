package com.immediateactiongroup.issues.security;

import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.service.UserRoleService;
import com.immediateactiongroup.issues.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午5:01
 */
@Service(value = "jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.querySingleUser(username);
        if( user == null){
            throw new UsernameNotFoundException("No user found with username:" + username);
        }
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = userService.queryUserRoles(user.getId());
        for(Role role : roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return JwtUserFactory.create(user, auths);
    }
}
