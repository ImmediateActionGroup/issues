package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.ProjectRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.ProjectAddDTO;
import com.immediateactiongroup.issues.dto.ProjectDTO;
import com.immediateactiongroup.issues.dto.ProjectUpdateDTO;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午4:35
 */
public interface ProjectService {
    /**
     * 添加project
     * @param projectAddDTO
     * @return
     * @throws BusinessException
     */
    ProjectDTO addProject(ProjectAddDTO projectAddDTO) throws BusinessException;

    /**
     * 更新项目信息
     * @param projectUpdateDTO
     * @throws BusinessException
     */
    void updateProject(ProjectUpdateDTO projectUpdateDTO) throws BusinessException;

    /**
     * 删除项目
     * @param projectId
     * @throws BusinessException
     */
    void deleteProject(Long projectId) throws BusinessException;

    /**
     * 添加单个成员
     * @param projectId
     * @param userId
     * @param role
     * @throws BusinessException
     */
    void addSingleMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException;

    /**
     * 添加多个成员
     * @throws BusinessException
     */
    void addMembersToProject() throws BusinessException;

    void removeMemberFromProject() throws BusinessException;

}
