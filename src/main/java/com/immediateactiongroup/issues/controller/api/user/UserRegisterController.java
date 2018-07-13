package com.immediateactiongroup.issues.controller.api.user;

import com.immediateactiongroup.issues.dto.user.UserIsExistResponse;
import com.immediateactiongroup.issues.dto.user.UserRegisterRequest;
import com.immediateactiongroup.issues.dto.user.UserRegisterResponse;
import com.immediateactiongroup.issues.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:15
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserRegisterController {

    /**
     * 用户注册
     * @param request 注册请求
     * @return 注册结果
     */
    @PostMapping("/user/register")
    public ResponseVO<UserRegisterResponse> register(UserRegisterRequest request){

        return null;
    }



    @GetMapping("/user/username/{username}")
    public ResponseVO<UserIsExistResponse> checkUsernameIsExist(@RequestParam String username){
        log.info("【】");
        return null;
    }


    @GetMapping("/user/email/{email}")
    public ResponseVO<UserIsExistResponse> checkEmailIsExist(@RequestParam String email){

        return null;
    }


    @GetMapping("/user/mobile/{mobile}")
    public ResponseVO<UserIsExistResponse> checkMobileIsExist(@RequestParam String mobile){
        return null;
    }

}
