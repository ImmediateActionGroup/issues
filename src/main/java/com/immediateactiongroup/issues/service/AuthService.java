package com.immediateactiongroup.issues.service;


import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;

/**
 * 用户认证相关
 * Created by beishan on 2017/9/2.
 */
public interface AuthService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 刷新Token
     * @param oldToken
     * @return
     */
    String refreshToken(String oldToken);

    UserDTO register(UserAddDTO userAddDTO);
}
