package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.dto.AddUserDTO;
import com.immediateactiongroup.issues.dto.UserDTO;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:03
 */
public interface UserService {

    UserDTO addUser(AddUserDTO addUserDTO);

    void deleteUser(Long id);

    List<UserDTO> queryAll();
}
