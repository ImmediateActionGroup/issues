package com.immediateactiongroup.issues.commons.exception;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 上午10:18
 */
public class BusinessException extends Exception{

    protected ExceptionEnum exceptionEnum;

    public BusinessException() {
    }

    public BusinessException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public BusinessException(String message, ExceptionEnum exceptionEnum) {
        super(message);
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
