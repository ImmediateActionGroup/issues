package com.immediateactiongroup.issues.commons.enums;

import lombok.Getter;

/**
 * @author weixueshan
 * @date 2017/11/29 17:36
 */
@Getter
public enum BizTagEnum {
    USER(1, "000001"),
    TEST(2, "000010"),
    ISSUES(3, "000011"),
    ISSUES_HISTORY(4, "000100"),
    ISSUES_LABEL(5, "000101"),
    ISSUES_TYPE(6, "000110"),
    LABEL(7, "000111"),
    PROJECT(8, "001000"),
    PROJECT_USER(9, "001001"),
    ROLE(10, "001010"),
    SPRINT(11, "001011"),
    SPRINT_ISSUES(12, "001100"),
    USER_ROLE(13, "001101"),
    ;
    private int value;
    private String name;

    BizTagEnum(int value, String name){
        this.value = value;
        this.name = name;
    }
}
