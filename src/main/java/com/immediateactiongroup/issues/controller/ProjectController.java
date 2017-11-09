package com.immediateactiongroup.issues.controller;

import com.immediateactiongroup.issues.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/11/9 下午11:48
 */
@Controller
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


}
