package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.BizTagEnum;
import com.immediateactiongroup.issues.commons.enums.DeleteFlagEnum;
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
    public boolean removeMemberFromProject(Long memberId) throws BusinessException {
        log.info("移除项目成员开始，memberId = {}", memberId);
        ProjectUser projectUser = queryById(memberId);
        if(Objects.nonNull(projectUser)){
            projectUser.setDeleteFlag(DeleteFlagEnum.DELETE_TRUE.getValue());
            projectUserMapper.updateByPrimaryKey(projectUser);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMemberByProjectIdAndUserId(Long projectId, Long userId) {
        log.info("移除项目成员开始, projectId = {}, userId = {}", projectId, userId);
        try{
            ProjectUser projectUser = queryByProjectIdAndUserId(projectId, userId);
            if(Objects.nonNull(projectUser)){
                projectUser.setDeleteFlag(DeleteFlagEnum.DELETE_TRUE.getValue());
                projectUserMapper.updateByPrimaryKey(projectUser);
                log.info("移除项目成员成功, projectId = {}, userId = {}", projectId, userId);
                return true;
            }
        }catch (Exception e){
            log.error("移除项目成员失败, ", e);
        }
        log.error("移除项目成员失败");
        return false;
    }

    @Override
    public void removeMembersFromProject() throws BusinessException {

    }
    private ProjectUser queryByProjectIdAndUserId(Long projectId, Long userId){
        ProjectUserExample projectUserExample = new ProjectUserExample();
        ProjectUserExample.Criteria criteria = projectUserExample.createCriteria();
        criteria.andProjectIdEqualTo(projectId)
                .andUserIdEqualTo(userId)
                .andDeleteFlagEqualTo(DeleteFlagEnum.DELETE_FALSE.getValue());
        List<ProjectUser> projectUsers = projectUserMapper.selectByExample(projectUserExample);
        if(projectUsers != null && projectUsers.size() > 0){
            return projectUsers.get(0);
        }
        return null;
    }
    @Override
    public void addMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException {
        log.info("添加项目成员开始, projectId = {}, userId = {}, role = {}", projectId, userId, role);
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
                .deleteFlag(DeleteFlagEnum.DELETE_FALSE.getValue())
                .build();
        projectUserMapper.insert(projectUser);
        log.info("添加项目成员成功, projectUser = {}", projectUser);
    }

    @Override
    public ProjectUser queryById(Long id) {
        ProjectUserExample projectUserExample = new ProjectUserExample();
        ProjectUserExample.Criteria criteria = projectUserExample.createCriteria();
        criteria.andDeleteFlagEqualTo(DeleteFlagEnum.DELETE_FALSE.getValue());
        criteria.andIdEqualTo(id);
        List<ProjectUser> projectUsers = projectUserMapper.selectByExample(projectUserExample);
        if(Objects.nonNull(projectUsers) && projectUsers.size() > 0){
            return projectUsers.get(0);
        }
        return null;
    }
}
