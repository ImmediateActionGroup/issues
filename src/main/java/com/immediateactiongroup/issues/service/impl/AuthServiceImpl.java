package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.RoleRepository;
import com.immediateactiongroup.issues.model.repository.UserRepository;
import com.immediateactiongroup.issues.security.JwtUser;
import com.immediateactiongroup.issues.service.AuthService;
import com.immediateactiongroup.issues.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2017/9/2.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDTO register(UserAddDTO userAddDTO) {
        final String username = userAddDTO.getUsername();
        if(userRepository.findByUsername(username) != null){
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userAddDTO.getPassword();
        final String encodePwd = encoder.encode(rawPassword);

        Role role = roleRepository.findByName("ROLE_USER");
        User newUser = userRepository.save(new User(username, encodePwd, role));
        return new UserDTO(newUser);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtUtils.generateToken(userDetails);
        return tokenHead + token;
    }

    @Override
    public String refreshToken(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtUtils.getUsernameFromToken(token);
        try{
            JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        }catch (UsernameNotFoundException e){
            // 没发现用户
            return null;
        }
        if(jwtUtils.canRefreshToken(token)){
            return jwtUtils.refreshToken(token);
        }
        return null;
    }
}
