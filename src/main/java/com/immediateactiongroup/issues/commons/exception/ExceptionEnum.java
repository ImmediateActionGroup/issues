package com.immediateactiongroup.issues.commons.exception;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 上午10:20
 */
public enum ExceptionEnum {

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
