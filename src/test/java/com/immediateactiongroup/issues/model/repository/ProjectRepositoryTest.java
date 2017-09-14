package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
