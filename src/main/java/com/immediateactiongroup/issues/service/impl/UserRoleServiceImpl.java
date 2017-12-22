package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.commons.enums.DeleteFlagEnum;
import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.UserRole;
import com.immediateactiongroup.issues.model.UserRoleExample;
import com.immediateactiongroup.issues.model.dao.UserRoleMapper;
import com.immediateactiongroup.issues.service.IdGenerateService;
import com.immediateactiongroup.issues.service.RoleService;
import com.immediateactiongroup.issues.service.UserRoleService;
import com.immediateactiongroup.issues.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author weixueshan
 * @date 2017/12/6 17:29
 */
@Service
@Slf4j
public class UserRoleServiceImpl extends BaseService implements UserRoleService {
    @Autowired
    private IdGenerateService idGenerateService;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleService roleService;

    private Long generateId(){
        return idGenerateService.generateId(BizTagEnum.USER_ROLE);
    }



    @Override
    public boolean addUserRole(Long userId, UserRoleEnum roleEnum){
        log.info("添加用户角色, userId = {}, roleEnum = {}", userId, roleEnum);
        Role role = roleService.queryRoleByName(roleEnum.name());
        try{
            if(Objects.isNull(role)){
                /**
                 * 如果发现数据库中对应的角色不存在则想数据库中添加相应角色
                 */
                roleService.addRole(roleEnum.getName());
                role = roleService.queryRoleByName(roleEnum.name());
            }
            UserRole userRole = queryByUserIdAndRoleId(userId, role.getId());
            /**
             * 用户未拥有该角色，则添加角色
             */
            if(Objects.isNull(userRole)){
                Long id = generateId();
                Date now = DateUtils.getNow();
                UserRole userRoles = UserRole.builder()
                        .id(id)
                        .userId(userId)
                        .roleId(role.getId())
                        .createTime(now)
                        .lastModifyTime(now)
                        .deleteFlag(DeleteFlagEnum.DELETE_FALSE.getValue())
                        .build();
                userRoleMapper.insert(userRoles);
                log.info("添加用户角色成功");
                return true;
            }else {
                log.error("添加用户角色出错, 用户已拥有该角色, userId = {}, roleEnum = {}", userId, roleEnum);
            }
        }catch (Exception e){
            log.error("添加用户角色出错", e);
        }
        return false;
    }

    @Override
    public List<UserRole> queryRolesByUserId(Long userId) {

        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDeleteFlagEqualTo(DeleteFlagEnum.DELETE_FALSE.getValue());
        return userRoleMapper.selectByExample(userRoleExample);
    }

    @Override
    public boolean removeUserRole(Long userId, UserRoleEnum roleEnum) {
        Role role = roleService.queryRoleByName(roleEnum.getName());
        if(Objects.nonNull(role)){
            UserRole userRole = queryByUserIdAndRoleId(userId, role.getId());
            if(Objects.nonNull(userRole)){
                userRoleMapper.deleteByPrimaryKey(userRole.getId());
                return true;
            }
        }
        return false;
    }

    @Override
    public UserRole queryByUserIdAndRoleId(Long userId, Long roleId) {
        UserRoleExample userRolesExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRolesExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andRoleIdEqualTo(roleId);
        criteria.andDeleteFlagEqualTo(DeleteFlagEnum.DELETE_FALSE.getValue());

        List<UserRole> userRoles = userRoleMapper.selectByExample(userRolesExample);
        if(Objects.nonNull(userRoles) && userRoles.size() > 0){
            return userRoles.get(0);
        }
        return null;
    }
}
