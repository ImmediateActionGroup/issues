package com.immediateactiongroup.issues.dto.user;

import lombok.Data;

/**
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:18
 */
@Data
public class UserRegisterRequest {
    /**
     *
     */
    private String email;
    private String mobile;
    private String username;
    private String password;
}
