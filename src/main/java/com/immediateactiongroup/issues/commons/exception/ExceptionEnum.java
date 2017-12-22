package com.immediateactiongroup.issues.commons.exception;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 上午10:20
 */
public enum ExceptionEnum {
    PARAMETER_ERROR("10000001", "参数错误"),
    /**
     * role
     */
    ROLE_NOT_EXIST("10010001", "角色不存在"),
    // user
    USER_NOT_EXIST("10020001", "用户不存在"),
    USER_IS_EXIST("10020002", "用户已经存在"),

    USER_OLDPWD_ERROR("10030002", "输入的旧密码不正确"),

    USER_ROLE_NOT_EXIST("10021001", "用户角色不存在"),

    //1. token
    TOKEN_ILLEGAL("10030001", "不合法的Token"),




    // 2.project
    PROJECT_ADD_EXIST("20000001", "项目已经存在"),
    PROJECT_IS_NOST_EXIST("20000002", "项目不存在"),
    // project user

    PU_ADDMEMBER_EXIST("20020001", "用户已经在项目中了"),
    PU_MEMBER_IS_NOT_EXIST("20022001", "用户不在项目中"),

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
