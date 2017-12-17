package com.immediateactiongroup.issues.commons.enums;

import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:09
 */
@Getter
@ToString
public enum UserRoleEnum {
    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(2, "ROLE_USER");
    ;
    private int value;
    private String name;

    UserRoleEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }
    public static UserRoleEnum index(int value) throws BusinessException{
        UserRoleEnum [] values = UserRoleEnum.values();
        for (UserRoleEnum roleEnum : values){
            if(roleEnum.getValue() == value){
                return roleEnum;
            }
        }
        return null;
    }
}
