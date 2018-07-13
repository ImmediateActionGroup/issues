package com.immediateactiongroup.issues.vo;

import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午6:08
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> {
    private static final String successCode = "00000000";
    private static final String successMessage = "success";
    private String code;
    private String message;
    private T data;

    public static <T> ResponseVO build(String code, String message, T data){
        return new ResponseVO(code, message, data);
    }
    public static <T> ResponseVO buildSuccess(String message, T data){
        return new ResponseVO(successCode, message, data);
    }
    public static <T> ResponseVO buildSuccess(T data){
        return new ResponseVO(successCode, successMessage, data);
    }

    public static ResponseVO buildFail(ExceptionEnum exceptionEnum){
        return ResponseVO.builder()
                .code(exceptionEnum.getCode())
                .message(exceptionEnum.getMessage())
                .build();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
