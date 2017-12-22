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
     * query a single project by id
     * if the project is not exist return null
     * @param id
     * @return
     * @throws BusinessException
     */
    ProjectDTO querySingleById(Long id) throws BusinessException;

    /**
     * query a single project by name
     * if the project is not exist return null
     * @param name
     * @return
     * @throws BusinessException
     */
    ProjectDTO querySingleByName(String name) throws BusinessException;

    /**
     * query a single project by key
     * if the project is not exist return null
     * @param key
     * @return
     * @throws BusinessException
     */
    ProjectDTO querySingleByKey(String key) throws BusinessException;

    /**
     * 根据项目名称&key查询项目
     * @param name 项目名称
     * @param key 项目key
     * @return
     * @throws BusinessException
     */
    ProjectDTO querySingleByNameAndKey(String name, String key) throws BusinessException;
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
     * 批量添加成员
     * @throws BusinessException
     */
    void addMembersToProject(Long projectId, ProjectRoleEnum role, Long ... ids) throws BusinessException;

    /**
     * 移除项目成员
     * @throws BusinessException
     */
    void removeMemberFromProject() throws BusinessException;

}
