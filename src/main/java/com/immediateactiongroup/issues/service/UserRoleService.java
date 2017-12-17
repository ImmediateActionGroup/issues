package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.model.UserRole;

import java.util.List;

/**
 * @author weixueshan
 * @date 2017/12/6 17:27
 */
public interface UserRoleService {
    /**
     * 添加用户角色
     * @param userId 用户ID
     * @param roleEnum 要添加的角色
     * @return
     */
    boolean addUserRole(Long userId, UserRoleEnum roleEnum);

    /**
     * 查询用户的角色
     * @param userId 用户ID
     * @return
     */
    List<UserRole> queryRolesByUserId(Long userId);

    /**
     * 移除用户角色
     * @param userId 用户ID
     * @param roleEnum 要移除的角色
     * @return
     */
    boolean removeUserRole(Long userId, UserRoleEnum roleEnum);

    /**
     * 根据用户ID & 角色ID查询
     * @param userId 用户ID
     * @param roleId 角色ID
     * @return
     */
    UserRole queryByUserIdAndRoleId(Long userId, Long roleId);
}
