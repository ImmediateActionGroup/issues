package com.immediateactiongroup.issues.controller;

import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.repository.UserRepository;
import com.immediateactiongroup.issues.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/8/23 下午6:07
 */
@RestController("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResultVO queryUsers(){
        List<User> users = userRepository.findAll();
        return ResultVO.build("1000000", "查询正常", users);
    }
}
