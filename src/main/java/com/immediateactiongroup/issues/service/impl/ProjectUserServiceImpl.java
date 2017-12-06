package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.commons.enums.ProjectRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.model.ProjectUser;
import com.immediateactiongroup.issues.model.ProjectUserExample;
import com.immediateactiongroup.issues.model.dao.ProjectUserMapper;
import com.immediateactiongroup.issues.service.ProjectUserService;
import com.immediateactiongroup.issues.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午5:33
 */
@Service
@Slf4j
public class ProjectUserServiceImpl extends BaseService  implements ProjectUserService {
    @Autowired
    private ProjectUserMapper projectUserMapper;

    private Long generateId(){
        return generateId(BizTagEnum.PROJECT_USER);
    }
    @Override
    public void disableMemberInProject(Long memberId) throws BusinessException {

    }

    @Override
    public void enableMemberInProject(Long memberId) throws BusinessException {

    }

    @Override
    public void changeMemberRoleInProject(Long memberId, ProjectRoleEnum newRole) throws BusinessException {

    }

    @Override
    public void removeMemberFromProject(Long memberId) throws BusinessException {

    }

    @Override
    public void removeMembersFromProject() throws BusinessException {

    }
    private ProjectUser queryByProjectIdAndUserId(Long projectId, Long userId){
        ProjectUserExample projectUserExample = new ProjectUserExample();
        ProjectUserExample.Criteria criteria = projectUserExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId)
                .andUserIdEqualTo(userId);
        List<ProjectUser> projectUsers = projectUserMapper.selectByExample(projectUserExample);
        if(projectUsers != null && projectUsers.size() > 0){
            return projectUsers.get(0);
        }
        return null;
    }
    @Override
    public void addMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException {

        ProjectUser projectUser = queryByProjectIdAndUserId(projectId, userId);
        if(Objects.nonNull(projectUser)){
            throw new BusinessException(ExceptionEnum.PU_ADDMEMBER_EXIST);
        }
        Date now = DateUtils.getNow();
        Long id = generateId();
        projectUser = ProjectUser.builder()
                .id(id)
                .projectId(projectId)
                .userId(userId)
                .role(role.getValue())
                .lastModifyTime(now)
                .createTime(now)
                .build();
        projectUserMapper.insert(projectUser);
    }
}
