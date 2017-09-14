package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.AddUserDTO;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserUpdateDTO;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:03
 */
public interface UserService {

    UserDTO addUser(AddUserDTO addUserDTO);

    void deleteUser(Long id) throws BusinessException;

    void deleteUsers(Long ...ids) throws BusinessException;

    List<UserDTO> queryAll();

    /**
     * 修改用户信息
     * @param userUpdateDTO
     * @throws BusinessException
     */
    void updateUserInfo(UserUpdateDTO userUpdateDTO) throws BusinessException;

    void changeUserPassword(Long userId, String oldPassword, String newPassword) throws BusinessException;

    void changeUserPassword(Long userId, String newPassword) throws BusinessException;
}
