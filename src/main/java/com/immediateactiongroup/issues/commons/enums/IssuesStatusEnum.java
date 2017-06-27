package com.immediateactiongroup.issues.commons.enums;

/**
 * issues 状态
 * Created by beishan on 2017/6/27.
 */
public enum IssuesStatusEnum {
    CREATED(0), //已创建
    OPEN(1), //打开
    INPROGRESS(2), //进行中
    COMPLETED(3), //完成
    CLOSE(4) //关闭
    ;
    private int value;

    IssuesStatusEnum(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}
