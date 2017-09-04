package com.immediateactiongroup.issues.controller;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.AddUserDTO;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import com.immediateactiongroup.issues.service.UserService;
import com.immediateactiongroup.issues.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午6:07
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseVO queryUsers(){
        List<UserDTO> users = userService.queryAll();
        return ResponseVO.buildSuccess(users);
    }

    /**
     * 管理员增加用户
     * @param userAddDTO
     * @return
     * @throws BusinessException
     */
    @PostMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseVO addUser(@RequestBody UserAddDTO userAddDTO) throws BusinessException{
        AddUserDTO addUserDTO = new AddUserDTO(userAddDTO.getUsername(),
                userAddDTO.getPassword(), UserRoleEnum.index(userAddDTO.getRole()));
        UserDTO newUser = userService.addUser(addUserDTO);
        return ResponseVO.buildSuccess("添加用户成功", newUser);
    }

    /**
     * 删除单个用户
     * @param id
     * @return
     * @throws BusinessException
     */
    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseVO deleteUser(@PathVariable Long id) throws BusinessException{

        userService.deleteUser(id);
        return ResponseVO.buildSuccess("删除用户成功[" + id + "]", null);
    }


}
