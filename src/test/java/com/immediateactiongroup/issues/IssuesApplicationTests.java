package com.immediateactiongroup.issues;

import com.immediateactiongroup.issues.service.SprintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssuesApplicationTests {

	@Autowired
	private SprintService sprintService;
	@Test
	public void contextLoads() {
        sprintService.queryAllByProjectId(1L);
	}

}
