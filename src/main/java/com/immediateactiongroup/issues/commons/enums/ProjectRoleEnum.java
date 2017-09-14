package com.immediateactiongroup.issues.commons.enums;

import lombok.Getter;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午4:46
 */
@Getter
public enum ProjectRoleEnum {
    OWNER(0, "创建者"),
    ADMIN(1, "管理者"),
    NORMAL(2, "普通成员")
    ;

    private String name;
    private int value;
    ProjectRoleEnum(int value, String name){
        this.name = name;
        this.value = value;
    }
}
