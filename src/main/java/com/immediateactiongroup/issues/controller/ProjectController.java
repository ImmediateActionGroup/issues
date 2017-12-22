package com.immediateactiongroup.issues.controller;

import com.immediateactiongroup.issues.commons.exception.BusinessException;
import com.immediateactiongroup.issues.dto.ProjectAddDTO;
import com.immediateactiongroup.issues.dto.ProjectDTO;
import com.immediateactiongroup.issues.service.ProjectService;
import com.immediateactiongroup.issues.vo.ResponseVO;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/11/9 下午11:48
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 根据id查询单个项目
     * @param id
     * @return
     * @throws BusinessException
     */
    @GetMapping("/project/{id}")
    public ResponseVO querySingleById(@PathVariable Long id) throws BusinessException{
        ProjectDTO projectDTO = projectService.querySingleById(id);
        return ResponseVO.buildSuccess(projectDTO);
    }

    /**
     * 根据项目key 查询项目是否存在
     * @param key 项目key
     * @return
     * @throws BusinessException
     */
    @GetMapping("/project/key/{key}")
    public ResponseVO queryIsExistByKey(@PathVariable String key) throws BusinessException{
        boolean isExist = projectService.queryIsExistByKey(key);
        Map result = new HashMap(1);
        result.put("isExist", isExist);
        return ResponseVO.buildSuccess(result);
    }

    /**
     * 根据项目name 查询项目是否存在
     * @param name 项目name
     * @return
     * @throws BusinessException
     */
    @GetMapping("/project/name/{name}")
    public ResponseVO queryIsExistByName(@PathVariable String name) throws BusinessException{
        boolean isExist = projectService.queryIsExistByName(name);
        Map result = new HashMap(1);
        result.put("isExist", isExist);
        return ResponseVO.buildSuccess(result);
    }

    /**
     * 创建项目
     * @param projectAddDTO 创建项目的参数
     * @return
     * @throws BusinessException
     */
    @PostMapping("/project")
    public ResponseVO addProject(@RequestBody ProjectAddDTO projectAddDTO) throws BusinessException{
        ProjectDTO projectDTO = projectService.addProject(projectAddDTO);
        return ResponseVO.buildSuccess(projectDTO);
    }

    /**
     * 删除项目
     * @param id
     * @return
     * @throws BusinessException
     */
    @DeleteMapping("/project/{id}")
    public ResponseVO deleteProject(@PathVariable Long id) throws BusinessException{
        projectService.deleteProject(id);
        return ResponseVO.buildSuccess(null);
    }
}
