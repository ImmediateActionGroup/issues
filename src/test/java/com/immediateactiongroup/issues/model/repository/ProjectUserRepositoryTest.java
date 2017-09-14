package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.model.ProjectUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午5:47
 */
public class ProjectUserRepositoryTest extends IssuesApplicationTests {
    @Autowired
    private ProjectUserRepository projectUserRepository;

    @Test
    public void testFind(){
        ProjectUser projectUser = projectUserRepository.findByProjectIdAndUserId(1L, 1L);
        System.out.println(projectUser);
    }
}
