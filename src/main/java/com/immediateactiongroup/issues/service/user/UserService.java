package com.immediateactiongroup.issues.service.user;

import com.immediateactiongroup.issues.dto.user.UserLoginRequest;
import com.immediateactiongroup.issues.dto.user.UserLoginResponse;

/**
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:49
 */
public interface UserService {

    /**
     * user login
     * @param request
     */
    UserLoginResponse login(UserLoginRequest request);

    /**
     * user logout
     */
    void logout();
}
