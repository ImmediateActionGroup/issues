package com.immediateactiongroup.issues.commons.enums;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:09
 */
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

    public int getValue() {
        return value;
    }
}
