package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import com.immediateactiongroup.issues.dto.validate.UserUpdateDTO;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.User;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/3 下午10:03
 * 用户相关操作类
 */
public interface UserAdminService {
    /**
     * 更改用户角色
     * @param userId 用户id
     * @param aimRole 角色枚举
     * @param addOrRemove 增加(true)或者是删除(false)角色
     * @return 更新是否成功 true 成功 | false 失败
     */
    boolean changeUserRole(Long userId, UserRoleEnum aimRole, boolean addOrRemove);

    /**
     * 添加用户角色
     * @param userId 用户ID
     * @param addRoleEnum 要添加的用户角色
     * @return 更新是否成功 true 成功 | false 失败
     */
    boolean addUserRole(Long userId, UserRoleEnum addRoleEnum);

    /**
     * 移除用户角色
     * @param userId 用户ID
     * @param removeRoleEnum 要删除的用户角色
     * @return 更新是否成功 true 成功 | false 失败
     */
    boolean remove(Long userId, UserRoleEnum removeRoleEnum);
    /**
     * query a single user by id
     * if the user is not exist return a null
     * @param userId
     * @return UserDTO or null (user not exist)
     */
    UserDTO querySingleUserById(Long userId);

    /**
     * query a single user by username
     * if the user is not exist return a null
     * @param username
     * @return UserDTO or null (user not exist)
     */
    UserDTO querySingleUserByUsername(String username);

    /**
     * 查询用户拥有的角色
     * @param userId
     * @return
     */
    List<Role> queryUserRoles(Long userId);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return
     */
    User querySingleUser(String username);

    /**
     * 增加用户接口
     * @param addUserDTO 用户基本信息
     * @return 新增的用户
     */
    UserDTO addUser(UserAddDTO addUserDTO) throws BusinessException;

    /**
     * 删除用户接口
     * @param id 用户ID
     * @throws BusinessException 出错时抛出的异常
     */
    void deleteUser(Long id) throws BusinessException;

    /**
     * 批量删除用户
     * @param ids 批量用户ID
     * @throws BusinessException
     */
    void deleteUsers(Long ...ids) throws BusinessException;

    /**
     * 查询所有用户接口
     * @return 所有用户
     */
    List<UserDTO> queryAll();

    /**
     * 修改用户信息接口
     * @param userUpdateDTO 要修改的用户信息
     * @return 修改后的用户信息
     * @throws BusinessException 出错时抛出的异常
     */
    UserDTO updateUserInfo(UserUpdateDTO userUpdateDTO) throws BusinessException;

    /**
     * 用户密码修改接口
     * 需要旧密码
     * @param userId 用户ID
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @throws BusinessException 出错时抛出的异常
     */
    void changeUserPassword(Long userId, String oldPassword, String newPassword) throws BusinessException;

    /**
     * 用户密码修改接口
     * 不需要旧密码
     * 此接口主要用于管理员修改密码
     * @param userId 用户ID
     * @param newPassword 新密码
     * @throws BusinessException 出错时抛出的异常
     */
    void changeUserPassword(Long userId, String newPassword) throws BusinessException;
}
