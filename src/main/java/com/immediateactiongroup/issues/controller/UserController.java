package com.immediateactiongroup.issues.controller;

import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.UserRepository;
import com.immediateactiongroup.issues.service.UserService;
import com.immediateactiongroup.issues.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午6:07
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseVO queryUsers(){
        List<UserDTO> users = userService.queryAll();
        return ResponseVO.buildSuccess(users);
    }
}
