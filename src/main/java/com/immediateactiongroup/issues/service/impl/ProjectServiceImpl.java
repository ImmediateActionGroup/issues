package com.immediateactiongroup.issues.service.impl;

import com.immediateactiongroup.issues.commons.enums.ProjectRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.commons.exception.ExceptionEnum;
import com.immediateactiongroup.issues.dto.ProjectAddDTO;
import com.immediateactiongroup.issues.dto.ProjectDTO;
import com.immediateactiongroup.issues.dto.ProjectUpdateDTO;
import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.model.Project;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.ProjectRepository;
import com.immediateactiongroup.issues.model.repository.UserRepository;
import com.immediateactiongroup.issues.service.ProjectService;
import com.immediateactiongroup.issues.service.ProjectUserService;
import com.immediateactiongroup.issues.service.UserService;
import com.immediateactiongroup.issues.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午6:11
 */
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectUserService projectUserService;

    @Autowired
    private UserService userService;

    @Override
    public ProjectDTO querySingleById(Long id) throws BusinessException {
        Project project = projectRepository.findOne(id);
        if(Objects.isNull(project)){
            return null;
        }
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .projectKey(project.getProjectKey())
                .creater(null)
                .createTime(project.getCreateTime())
                .lastModifyTime(project.getLastModifyTime())
                .build();
    }

    @Override
    public ProjectDTO querySingleByName(String name) throws BusinessException {
        Project project = projectRepository.findByName(name);
        if(Objects.isNull(project)){
            return null;
        }
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .projectKey(project.getProjectKey())
                .creater(null)
                .createTime(project.getCreateTime())
                .lastModifyTime(project.getLastModifyTime())
                .build();
    }

    @Override
    public ProjectDTO querySingleByKey(String key) throws BusinessException {
        Project project = projectRepository.findByProjectKey(key);
        if(Objects.isNull(project)){
            return null;
        }
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .projectKey(project.getProjectKey())
                .creater(null)
                .createTime(project.getCreateTime())
                .lastModifyTime(project.getLastModifyTime())
                .build();
    }

    @Override
    public void updateProject(ProjectUpdateDTO projectUpdateDTO) throws BusinessException {
        // TODO: 2017/11/8
    }

    @Override
    public void removeMemberFromProject() throws BusinessException {
        // TODO: 2017/11/8
    }

    @Override
    public ProjectDTO addProject(ProjectAddDTO projectAddDTO) throws BusinessException {
        User user = userRepository.findById(projectAddDTO.getCreaterId());
        if(user == null){
            log.error("[添加项目] 项目创建者id:{}不存在", projectAddDTO.getCreaterId());
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }

        // check project is exist by name and key
        List<Project> projects = projectRepository.findAllByNameOrProjectKey(projectAddDTO.getName(), projectAddDTO.getKey());
        if(Objects.nonNull(projects) && projects.size() > 0){
            log.error("添加项目失败，项目名称:{}或者key:{}已经存在", projectAddDTO.getName(), projectAddDTO.getKey());
            throw new BusinessException(ExceptionEnum.PROJECT_ADD_EXIST);
        }
        Project project = new Project();
        project.setName(projectAddDTO.getName());
        project.setProjectKey(projectAddDTO.getKey());
        project.setDescription(projectAddDTO.getDescription());
        Date now = DateUtils.getNow();
        project.setCreateTime(now);
        project.setLastModifyTime(now);
        project.setCreater(user);

        project = projectRepository.save(project);

        // 把创建者加入项目
        projectUserService.addMemberToProject(project.getId(), user.getId(), ProjectRoleEnum.OWNER);
        return new ProjectDTO(project);
    }

    @Override
    public void deleteProject(Long projectId) throws BusinessException {
        // TODO: 2017/9/14 待实现
    }

    @Override
    public void addSingleMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException {
        // step1: check the project is exist
        Project project = projectRepository.findOne(projectId);
        if(project == null){
            log.error("[添加项目成员] 项目{}不存在", projectId);
            throw new BusinessException(ExceptionEnum.PROJECT_IS_NOST_EXIST);
        }
        // step2: check the user is exist
        User user = userRepository.findById(userId);
        if(user == null){
            log.error("[添加项目成员] 用户{}不存在", userId);
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }
        
        projectUserService.addMemberToProject(projectId, userId, role);
    }

    @Override
    public void addMembersToProject(Long projectId, ProjectRoleEnum role, Long... ids) throws BusinessException {
        // step1: check the project is exist
        Project project = projectRepository.findOne(projectId);
        if(project == null){
            log.error("[添加项目成员] 项目{}不存在", projectId);
            throw new BusinessException(ExceptionEnum.PROJECT_IS_NOST_EXIST);
        }

        for (int i = 0; i < ids.length; i++) {
            try {
                addMemberToProject(projectId, ids[i], role);
                log.info("批量插入用户成功，成功的用户id为: {}, 项目id为: {}, 角色为: {}", ids[i], projectId, role.getName());
            }catch (BusinessException e){
                log.error("批量插入用户失败，失败的用户id: {}, 项目id为: {}, 角色为: {}", ids[i], projectId, role.getName());
            }
        }
    }

    private void addMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException{
        // step1: check the user is exist
        UserDTO user = userService.querySingleUserById(userId);
        if(Objects.isNull(user)){
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        }
        // step2: add user to project
        projectUserService.addMemberToProject(projectId, userId, role);
    }
}
