package com.immediateactiongroup.issues.config.init;

import com.immediateactiongroup.issues.commons.enums.UserRoleEnum;
import com.immediateactiongroup.issues.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author weixueshan
 * @date 2017/12/6 17:44
 */
@Configuration
public class DataBaseInitConfig {
    // TODO: 2017/12/6 这里要写role 初始化
    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void init(){
        initRole();
    }
    private void initRole(){
        int roleTotal = roleService.count();
        if(roleTotal == 0){
            UserRoleEnum [] userRoleEnums = UserRoleEnum.values();

        }
    }
}
