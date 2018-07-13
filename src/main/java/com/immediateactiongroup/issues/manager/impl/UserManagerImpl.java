package com.immediateactiongroup.issues.manager.impl;

import com.immediateactiongroup.issues.manager.UserManager;
import com.immediateactiongroup.issues.model.User;
import com.immediateactiongroup.issues.model.UserExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:58
 */

@Service
@Slf4j
public class UserManagerImpl implements UserManager {

    @Override
    public User selectByUserMobile(String mobile) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.and
        return null;
    }

    @Override
    public User selectByUserEmail(String email) {
        return null;
    }
}
