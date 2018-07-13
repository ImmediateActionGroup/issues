package com.immediateactiongroup.issues.dto.user;

import lombok.Data;

/**
 * 用户登录
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:45
 */
@Data
public class UserLoginRequest {
    private String identification;
    private String password;
}
