package com.immediateactiongroup.issues.commons.exception;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 上午10:20
 */
public enum ExceptionEnum {

    // user
    USER_NOT_EXIST("10020001", "用户不存在"),

    USER_ROLE_NOT_EXIST("10021001", "用户角色不存在"),

    //1. token
    TOKEN_ILLEGAL("10030001", "不合法的Token")
    ;
    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
