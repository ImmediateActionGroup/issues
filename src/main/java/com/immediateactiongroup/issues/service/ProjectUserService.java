package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.ProjectRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.model.ProjectUser;

/**
 * @Author xueshan.wei
 * @Date 2017/9/14 下午5:34
 */
public interface ProjectUserService {

    /**
     * 添加成员
     * @param projectId
     * @param userId
     * @param role
     * @throws BusinessException
     */
    void addMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException;

    /**
     * 项目中封禁用户
     * @param memberId 成员id
     * @throws BusinessException
     */
    void disableMemberInProject(Long memberId) throws BusinessException;

    /**
     * 解禁项目用户
     * @param memberId 成员id
     * @throws BusinessException
     */
    void enableMemberInProject(Long memberId) throws BusinessException;

    /**
     * 更改项目成员身份
     * @param memberId
     * @param newRole
     * @throws BusinessException
     */
    void changeMemberRoleInProject(Long memberId, ProjectRoleEnum newRole) throws BusinessException;

    /**
     * 移除项目成员
     * @param memberId
     * @throws BusinessException
     */
    boolean removeMemberFromProject(Long memberId) throws BusinessException;

    /**
     * 移除项目成员
     * @param projectId 项目ID
     * @param userId 用户ID
     * @return
     */
    boolean removeMemberByProjectIdAndUserId(Long projectId, Long userId);

    void removeMembersFromProject() throws BusinessException;

    /**
     * 通过ID查询
     * @param id ID
     * @return
     */
    ProjectUser queryById(Long id);
}
