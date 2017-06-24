package com.immediateactiongroup.issues.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by beishan on 2017/6/24.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        return "sprint";
    }
}
