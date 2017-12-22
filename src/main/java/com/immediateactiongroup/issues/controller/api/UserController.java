package com.immediateactiongroup.issues.controller.api;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.AddUserDTO;
import com.immediateactiongroup.issues.dto.BatchDeleteUserDTO;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import com.immediateactiongroup.issues.dto.validate.UserUpdateDTO;
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
@RestController("apiUserController")
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
        // TODO: 2017/12/8 修改
        UserDTO newUser = userService.addUser(null);
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

    /**
     * 批量删除用户
     *
     * @param batchDeleteUserDTO
     * @return
     * @throws BusinessException
     */
    @DeleteMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseVO batchDeleteUser(@RequestBody BatchDeleteUserDTO batchDeleteUserDTO) throws BusinessException{

        userService.deleteUsers(batchDeleteUserDTO.getIds());
        return ResponseVO.buildSuccess("批量删除用户信息成功");
    }

    /**
     * 更新用户信息
     * @param userUpdateDTO 参数
     * @return 修改后的用户信息
     * @throws BusinessException 出错时抛出的异常
     */
    @PutMapping("/sys/user/{id}")
    public ResponseVO updateUser(@RequestBody UserUpdateDTO userUpdateDTO) throws BusinessException{
        UserDTO userDTO = userService.updateUserInfo(userUpdateDTO);
        return ResponseVO.buildSuccess("更新用户信息成功", userDTO);
    }

    /**
     * 修改用户密码
     * 用户身份：管理员
     * @return
     * @throws BusinessException
     */
    @PutMapping("/sys/user/{id}/password")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseVO changeUserPasswordSys(@PathVariable Long id, @RequestParam String newPassword) throws BusinessException{
        userService.changeUserPassword(id, newPassword);
        return ResponseVO.buildSuccess("修改用户密码成功", null);
    }

    /**
     * 修改用户密码
     * 用户身份：普通用户（自己）
     * @return
     * @throws BusinessException
     */
    @PutMapping("/user/{id}/password")
    public ResponseVO changeUserPassword(@PathVariable Long id, @RequestParam String oldPassword,
                                         @RequestParam String newPassword) throws BusinessException{

        userService.changeUserPassword(id, oldPassword, newPassword);
        return ResponseVO.buildSuccess("修改用户密码成功", null);
    }

}
