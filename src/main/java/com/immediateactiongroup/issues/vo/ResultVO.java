package com.immediateactiongroup.issues.vo;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午6:08
 */
public class ResultVO {

    private String code;
    private String message;
    private Object data;

    public static ResultVO build(String code, String message, Object data){
        return new ResultVO(code, message, data);
    }

    public ResultVO(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
