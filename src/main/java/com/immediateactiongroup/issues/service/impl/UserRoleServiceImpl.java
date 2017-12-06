package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.model.Role;
import com.immediateactiongroup.issues.model.RoleExample;
import com.immediateactiongroup.issues.model.UserRoles;
import com.immediateactiongroup.issues.model.UserRolesExample;
import com.immediateactiongroup.issues.model.dao.UserRolesMapper;
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
    private UserRolesMapper userRolesMapper;
    @Autowired
    private RoleService roleService;

    private Long generateId(){
        return idGenerateService.generateId(BizTagEnum.USER_ROLE);
    }
    @Override
    public void addUserRole(Long userId, UserRoleEnum roleEnum) throws BusinessException {
        Role role = roleService.queryRoleByName(roleEnum.name());
        if(Objects.isNull(role)){
            throw new BusinessException(ExceptionEnum.ROLE_NOT_EXIST);
        }
        Long id = generateId();
        Date now = DateUtils.getNow();
        UserRoles userRoles = UserRoles.builder()
                .id(id)
                .userId(userId)
                .roleId(role.getId())
                .createTime(now)
                .lastModifyTime(now)
                .build();
        userRolesMapper.insert(userRoles);
    }

    @Override
    public List<UserRoles> queryRolesByUserId(Long userId) {

        UserRolesExample userRolesExample = new UserRolesExample();
        UserRolesExample.Criteria criteria = userRolesExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userRolesMapper.selectByExample(userRolesExample);
    }
}
