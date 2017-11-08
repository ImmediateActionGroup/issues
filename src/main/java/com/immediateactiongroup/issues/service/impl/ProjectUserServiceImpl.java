package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.ProjectRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.model.Project;
import com.immediateactiongroup.issues.model.ProjectUser;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.ProjectUserRepository;
import com.immediateactiongroup.issues.service.ProjectUserService;
import com.immediateactiongroup.issues.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午5:33
 */
@Service
public class ProjectUserServiceImpl  implements ProjectUserService {

    @Autowired
    private ProjectUserRepository projectUserRepository;

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

    @Override
    public void addMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException {
        ProjectUser projectUser = projectUserRepository.findByProjectIdAndUserId(projectId, userId);

        if(projectUser != null){
            throw new BusinessException(ExceptionEnum.PU_ADDMEMBER_EXIST);
        }

        projectUser = new ProjectUser();
        projectUser.setJoinTime(DateUtils.getNow());

        Project project = new Project();
        project.setId(projectId);

        projectUser.setRole(role.getValue());
        User user = new User();
        user.setId(userId);

        projectUser.setProject(project);
        projectUser.setUser(user);

        projectUserRepository.save(projectUser);
    }
}
