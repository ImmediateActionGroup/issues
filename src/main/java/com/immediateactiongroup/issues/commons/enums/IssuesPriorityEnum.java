package com.immediateactiongroup.issues.commons.enums;

/**
 * Issues 优先级
 * 分为五个优先级：highest, high, medium, low, lowest
 * Created by beishan on 2017/6/27.
 */
public enum IssuesPriorityEnum {

    HIGHEST(0),
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    LOWEST(4)
    ;

    private int value;

    IssuesPriorityEnum(int value) {
        this.value = value;
    }
    public int value(){
        return value;
    }
}
