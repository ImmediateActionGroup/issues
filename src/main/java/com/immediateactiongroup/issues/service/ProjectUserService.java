package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.commons.enums.ProjectRoleEnum;
import com.immediateactiongroup.issues.commons.exception.BusinessException;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午5:34
 */
public interface ProjectUserService {

    void addMemberToProject(Long projectId, Long userId, ProjectRoleEnum role) throws BusinessException;
}
