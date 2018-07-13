package com.immediateactiongroup.issues.service.user.impl;

import com.immediateactiongroup.issues.dto.user.UserLoginRequest;
import com.immediateactiongroup.issues.dto.user.UserLoginResponse;
import com.immediateactiongroup.issues.model.dao.UserMapper;
import com.immediateactiongroup.issues.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:52
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserLoginResponse login(UserLoginRequest request) {

        return null;
    }

    @Override
    public void logout() {

    }
}
