package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.AddUserDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/4 上午11:04
 */
public class UserServiceTest extends IssuesApplicationTests {
    @Autowired
    private UserService userService;

    @Test(expected = BusinessException.class)
    public void testDeleteUser() throws BusinessException{
        userService.deleteUser(4L);
    }


    @Test
    public void testAddUser(){
        AddUserDTO addUserDTO = new AddUserDTO("tester01", "123456", UserRoleEnum.ROLE_USER);
        userService.addUser(addUserDTO);
    }

    @Test
    public void testChangeUserPassword1() throws Exception{
        userService.changeUserPassword(1L, "123456");
    }

    @Test
    public void testChangeUserPassword2() throws Exception{
        userService.changeUserPassword(2L, "123456", "654321");
    }
}
