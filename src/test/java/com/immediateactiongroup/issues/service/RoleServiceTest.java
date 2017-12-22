package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xueshan.wei
 * @Date 2017/12/17 上午11:18
 */
public class RoleServiceTest extends IssuesApplicationTests {
    @Autowired
    private RoleService roleService;

    @Test
    public void testAddRole() throws Exception{
        for(UserRoleEnum roleEnum : UserRoleEnum.values()){
            roleService.addRole(roleEnum.getName());
        }
    }
}
