package com.immediateactiongroup.issues.commons.enums;

import lombok.Getter;

/**
 * @author weixueshan
 * @date 2017/11/29 18:17
 */
@Getter
public enum DeleteFlagEnum {
    DELETE_TRUE(1, "true"),
    DELETE_FALSE(0, "false")
    ;

    private int value;
    private String name;

    DeleteFlagEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
