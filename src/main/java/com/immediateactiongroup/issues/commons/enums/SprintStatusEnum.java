package com.immediateactiongroup.issues.commons.enums;

/**
 * sprint 状态
 *
 * Created by beishan on 2017/6/27.
 */
public enum SprintStatusEnum {
    CREATED(0), //已创建
    OPEN(1), //打开状态
    CLOSED(2) //已关闭
    ;
    private int value;

    SprintStatusEnum(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}
