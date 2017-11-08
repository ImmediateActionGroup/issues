package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.dto.ProjectAddDTO;
import com.immediateactiongroup.issues.dto.ProjectDTO;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午6:27
 */
public class ProjectServiceTest extends IssuesApplicationTests {
    @Autowired
    private ProjectService projectService;


    @Test
    public void testQuerySingleById() throws Exception{
        // step1: generate a unique project name and key
        Long currentMills = System.currentTimeMillis();
        String uniqueProjectName = "project_" + currentMills.toString();
        String uniquePorjectKey = "key_" + currentMills.toString();

        ProjectAddDTO projectAddDTO = ProjectAddDTO.builder()
                .name(uniqueProjectName)
                .key(uniquePorjectKey)
                .description("...")
                .createrId(1L)
                .build();

        // step2: save the user

        ProjectDTO newProject = projectService.addProject(projectAddDTO);

        // step3: query the user
        ProjectDTO existUser = projectService.querySingleById(newProject.getId());
        Assert.notNull(existUser);

        // step4: generate a not exist user by a special id
        // 一个大的数
        Long userId = Long.MAX_VALUE;
        ProjectDTO notExistUser = projectService.querySingleById(userId);
        Assert.isNull(notExistUser);



    }
    @Test
    public void testAddProject() throws Exception{
        ProjectAddDTO projectAddDTO = new ProjectAddDTO();
        projectAddDTO.setCreaterId(1L);
        projectAddDTO.setName("Project1");
        projectAddDTO.setKey("CSXM");
        projectAddDTO.setDescription("meiyou");

        projectService.addProject(projectAddDTO);
    }
}
