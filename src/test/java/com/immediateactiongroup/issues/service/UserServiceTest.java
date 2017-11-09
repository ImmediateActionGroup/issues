package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.AddUserDTO;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserUpdateDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/4 上午11:04
 */
@Transactional
public class UserServiceTest extends IssuesApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void testQuerySingleUser() throws Exception{
        // step1: create a new user
        Long currentMills = System.currentTimeMillis();
        String newUserName  = "newuser_" + currentMills.toString();

        AddUserDTO addUserDTO = AddUserDTO.builder()
                .username(newUserName)
                .password("123456")
                .roleEnum(UserRoleEnum.ROLE_USER).build();
        UserDTO newUser = userService.addUser(addUserDTO);

        // step2: query the user
        UserDTO actualUser = userService.querySingleUserById(newUser.getId());

        //step3: assert the user is exist
        Assert.assertNotNull(actualUser);
    }
    @Test
    public void testAddUser() throws Exception{
        // step1: create a new user
        Long currentMills = System.currentTimeMillis();
        String newUserName  = "newuser_" + currentMills.toString();

        AddUserDTO addUserDTO = AddUserDTO.builder()
                .username(newUserName)
                .password("123456")
                .roleEnum(UserRoleEnum.ROLE_USER).build();
        UserDTO newUser = userService.addUser(addUserDTO);

        // step2: assert the user has add success
        Assert.assertNotNull(newUser);
    }

    @Test(expected = BusinessException.class)
    public void testDeleteUser() throws BusinessException{

        // step1: 新创建一个用户,确保用户名不重复
        Long currentMills = System.currentTimeMillis();
        String newUserName  = "newuser_" + currentMills.toString();

        AddUserDTO addUserDTO = AddUserDTO.builder()
                .username(newUserName)
                .password("123456")
                .roleEnum(UserRoleEnum.ROLE_USER).build();
        UserDTO newUser = userService.addUser(addUserDTO);
        // assert new user add success
        Assert.assertNotNull(newUser);
        // step2: delete the user
        userService.deleteUser(newUser.getId());

        // step3: assert have delete the user
        UserDTO existUser = userService.querySingleUserById(newUser.getId());

        Assert.assertNull(existUser);

    }


    /**
     * @see com.immediateactiongroup.issues.service.UserService
     * @throws Exception
     */
    @Test
    public void testChangeUserPassword1() throws Exception{
        userService.changeUserPassword(1L, "123456");
    }

    @Test
    public void testChangeUserPassword2() throws Exception{
        userService.changeUserPassword(2L, "123456", "654321");
    }

    @Test
    public void testUpdateUserInfo() throws BusinessException {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO.setId(1L);
        userUpdateDTO.setNickname("new nickname");

        UserDTO userDTO = userService.updateUserInfo(userUpdateDTO);

        System.out.println(userDTO);
    }
}
