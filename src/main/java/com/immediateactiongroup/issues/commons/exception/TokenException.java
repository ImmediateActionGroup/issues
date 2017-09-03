package com.immediateactiongroup.issues.commons.exception;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 上午10:19
 */
public class TokenException extends BusinessException {
    public TokenException(String message, ExceptionEnum exceptionEnum) {
        super(message, exceptionEnum);
    }

    public TokenException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}
