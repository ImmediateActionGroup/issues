package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.dao.RoleMapper;
import com.immediateactiongroup.issues.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weixueshan
 * @date 2017/12/6 17:35
 */
@Service
@Slf4j
public class RoleServiceImpl extends BaseService implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    private Long generateId(){
        return generateId(BizTagEnum.ROLE);
    }
    @Override
    public Role queryRoleByName(String name) {
        return roleMapper.selectByName(name);
    }
}
