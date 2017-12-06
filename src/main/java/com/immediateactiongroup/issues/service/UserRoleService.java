package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.UserRoles;

import java.util.List;

/**
 * @author weixueshan
 * @date 2017/12/6 17:27
 */
public interface UserRoleService {
    /**
     * 添加用户角色
     * @param userId
     * @param roleEnum
     * @throws BusinessException
     */
    void addUserRole(Long userId, UserRoleEnum roleEnum) throws BusinessException;

    /**
     * 查询用户的角色
     * @param userId
     * @return
     */
    List<UserRoles> queryRolesByUserId(Long userId);
}
