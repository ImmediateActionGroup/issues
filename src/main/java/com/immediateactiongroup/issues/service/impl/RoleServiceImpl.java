package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.dao.RoleMapper;
import com.immediateactiongroup.issues.service.RoleService;
import com.immediateactiongroup.issues.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<Role> queryByIds(Long... ids) {
        return roleMapper.selectByIds(ids);
    }

    @Override
    public Role queryById(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int count() {
        return roleMapper.count();
    }

    @Override
    public void addRole(String name) {
        Long id = generateId();
        Date now = DateUtils.getNow();
        Role role = Role.builder()
                .id(id)
                .name(name)
                .createTime(now)
                .lastModifyTime(now)
                .build();
        roleMapper.insert(role);
    }
}
