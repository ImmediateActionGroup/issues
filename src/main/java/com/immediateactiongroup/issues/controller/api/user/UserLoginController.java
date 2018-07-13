package com.immediateactiongroup.issues.controller.api.user;

import com.immediateactiongroup.issues.dto.user.UserLoginRequest;
import com.immediateactiongroup.issues.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:43
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserLoginController {

    @PostMapping("/user/session")
    public ResponseVO login(@RequestBody UserLoginRequest request){
        log.info("[user-login] request: {}", request);
        return null;
    }

    @DeleteMapping("/user/session")
    public ResponseVO logout(){
        log.info("[user-logout]");
        return null;
    }
}
