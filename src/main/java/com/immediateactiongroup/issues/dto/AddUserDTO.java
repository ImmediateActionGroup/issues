package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import lombok.Builder;
import lombok.Data;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:07
 */

@Data
@Builder
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
}
