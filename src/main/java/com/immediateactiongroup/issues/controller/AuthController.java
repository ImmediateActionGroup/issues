package com.immediateactiongroup.issues.controller;

import com.immediateactiongroup.issues.dto.UserDTO;
import com.immediateactiongroup.issues.dto.validate.UserAddDTO;
import com.immediateactiongroup.issues.dto.validate.UserLoginDTO;
import com.immediateactiongroup.issues.service.AuthService;
import com.immediateactiongroup.issues.vo.ResponseVO;
import com.immediateactiongroup.issues.vo.TokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by beishan on 2017/9/2.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @PostMapping("/session")
    public ResponseVO getAuthToken(@RequestBody UserLoginDTO userLoginDTO){
        System.out.println(userLoginDTO);
        final String token = authService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        TokenVO tokenVO = new TokenVO(token);
        return ResponseVO.buildSuccess(tokenVO);
    }

    @PostMapping("/user")
    public ResponseVO register(@RequestBody UserAddDTO userAddDTO){
        System.out.println(userAddDTO);
        final UserDTO userDTO = authService.register(userAddDTO);
        return ResponseVO.buildSuccess(userDTO);
    }
}
