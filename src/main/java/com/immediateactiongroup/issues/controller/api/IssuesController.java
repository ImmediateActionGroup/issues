package com.immediateactiongroup.issues.controller.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by beishan on 2017/6/29.
 */
@RestController("apiIssuesController")
public class IssuesController {

    @RequestMapping("/project/{projectId}/sprint/{sprintId}")
    public String sprintPage(@PathVariable Long projectId, @PathVariable Long sprintId, Model model){

        return "sprint";
    }
}
