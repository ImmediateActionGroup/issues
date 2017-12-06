package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;

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
}
