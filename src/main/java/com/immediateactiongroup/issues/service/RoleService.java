package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.model.Role;

import java.util.List;

/**
 * @author weixueshan
 * @date 2017/12/6 17:33
 */
public interface RoleService {
    /**
     * 通过role name 查询
     * @param name
     * @return
     */
    Role queryRoleByName(String name);

    /**
     *
     * @param ids
     * @return
     */
    List<Role> queryByIds(Long ...ids);

    Role queryById(Long id);

    int count();

    void addRole(String name);
}
