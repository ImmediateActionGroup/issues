package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 上午11:03
 */
public class AuthServiceTest extends IssuesApplicationTests{

    @Autowired
    private AuthService authService;
    @Test
    public void testRegister(){
        UserAddDTO userAddDTO = new UserAddDTO();
        userAddDTO.setUsername("user_test");
        userAddDTO.setPassword("123456");

        UserDTO userDTO = authService.register(userAddDTO);
        System.out.println(userDTO);
    }
}
