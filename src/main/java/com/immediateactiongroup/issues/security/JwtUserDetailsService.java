package com.immediateactiongroup.issues.security;

import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午5:01
 */
@Service(value = "jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if( user == null){
            throw new UsernameNotFoundException("No user found with username:" + username);
        }
        return JwtUserFactory.create(user);
    }
}
