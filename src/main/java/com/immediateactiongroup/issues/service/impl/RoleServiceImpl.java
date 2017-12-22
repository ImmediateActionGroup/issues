package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.commons.enums.DeleteFlagEnum;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.RoleExample;
import com.immediateactiongroup.issues.model.dao.RoleMapper;
import com.immediateactiongroup.issues.service.RoleService;
import com.immediateactiongroup.issues.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andDeleteFlagEqualTo(DeleteFlagEnum.DELETE_FALSE.getValue());
        List<Role> roles = roleMapper.selectByExample(roleExample);
        if(Objects.nonNull(roles) && roles.size() > 0){
            return roles.get(0);
        }
        return null;
    }

    @Override
    public List<Role> queryByIds(Long... ids) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        criteria.andDeleteFlagEqualTo(DeleteFlagEnum.DELETE_FALSE.getValue());
        return roleMapper.selectByExample(roleExample);
    }

    @Override
    public Role queryById(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int count() {
        //return roleMapper.countTotal();
        return 1;
    }

    @Override
    public void addRole(String name) {
        log.info("添加角色开始, name = {}", name);
        Long startMills = System.currentTimeMillis();
        Role role = queryRoleByName(name);
        if(Objects.nonNull(role)){
            log.error("添加角色失败, 角色名已存在, name = {}", name);
            return;
        }
        Long id = generateId();
        Date now = DateUtils.getNow();
        role = Role.builder()
                .id(id)
                .name(name)
                .createTime(now)
                .lastModifyTime(now)
                .deleteFlag(DeleteFlagEnum.DELETE_FALSE.getValue())
                .build();
        roleMapper.insert(role);
        Long endMills = System.currentTimeMillis();

        log.info("添加角色成功, 用时 = {}", endMills - startMills);
    }
}
