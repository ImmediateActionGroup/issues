package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import com.immediateactiongroup.issues.security.JwtUser;
import com.immediateactiongroup.issues.service.AuthService;
import com.immediateactiongroup.issues.service.IdGenerateService;
import com.immediateactiongroup.issues.service.RoleService;
import com.immediateactiongroup.issues.service.UserAdminService;
import com.immediateactiongroup.issues.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2017/9/2.
 */
@Service
@Slf4j
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
    private UserAdminService userAdminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private IdGenerateService idGenerateService;

    private Long generateId(){
        return idGenerateService.generateId(BizTagEnum.USER);
    }
    @Override
    public UserDTO register(UserAddDTO userAddDTO){
        UserDTO userDTO = null;
        try {
            userDTO = userAdminService.addUser(userAddDTO);
        } catch (BusinessException e) {
            log.error("register 用户出错, {}", userAddDTO.toString());
            userDTO = null;
        }
        return userDTO;
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
