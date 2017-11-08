package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.dto.SprintDTO;

import java.util.List;

/**
 * Created by beishan on 2017/6/29.
 */
public interface SprintService {
    /**
     * 查询某个项目下所有的Sprint
     * @param projectId
     * @return 返回该项目下所有的sprint
     */
    List<SprintDTO> queryAllByProjectId(Long projectId);

    /**
     * 根据id查询Sprint
     * @param sprintId
     * @return
     */
    SprintDTO querySingleById(Long sprintId);
}
