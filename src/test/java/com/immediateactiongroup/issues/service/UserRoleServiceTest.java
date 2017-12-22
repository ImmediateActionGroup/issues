package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.model.UserRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author xueshan.wei
 * @Date 2017/12/17 下午12:24
 */
public class UserRoleServiceTest extends IssuesApplicationTests {
    @Autowired
    private UserRoleService userRoleService;
    @Test
    public void testQueryUserRoles() throws Exception{
        Long userId = 10402261318766592L;
        List<UserRole> roles = userRoleService.queryRolesByUserId(userId);
        roles.stream().forEach(System.out::println);
    }
}
