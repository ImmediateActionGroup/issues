package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:07
 */
public class AddUserDTO {

    private String username;
    private String password;
    private UserRoleEnum roleEnum;

    public AddUserDTO() {
    }

    public AddUserDTO(String username, String password, UserRoleEnum roleEnum) {
        this.username = username;
        this.password = password;
        this.roleEnum = roleEnum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(UserRoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
