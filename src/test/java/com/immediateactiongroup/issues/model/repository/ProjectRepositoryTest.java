package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.model.Project;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午6:33
 */
public class ProjectRepositoryTest extends IssuesApplicationTests {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void testQuery(){
        projectRepository.findByNameAndProjectKey("eeee", "CSXM");
    }

    @Test
    public void testFindByNameOrProjectKey() throws Exception{
        String projectName = "Project1";
        String projectKey = "";

        List<Project> projects = projectRepository.findAllByNameOrProjectKey("", "CSXM");
        Project project = projectRepository.findByNameOrProjectKey(projectName, projectKey);
        Project project2 = projectRepository.findByNameOrProjectKey("", "");
        //Project project3 = projectRepository.findByNameOrProjectKey("", "CSXM");

        System.out.println(project.toString());
        //System.out.println(project2.toString());
        System.out.println(projects.size());
    }
}
