package com.immediateactiongroup.issues.service;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.dto.ProjectAddDTO;
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
    public void testAddProject() throws Exception{
        ProjectAddDTO projectAddDTO = new ProjectAddDTO();
        projectAddDTO.setCreaterId(1L);
        projectAddDTO.setName("Project1");
        projectAddDTO.setKey("CSXM");
        projectAddDTO.setDescription("meiyou");

        projectService.addProject(projectAddDTO);
    }
}
