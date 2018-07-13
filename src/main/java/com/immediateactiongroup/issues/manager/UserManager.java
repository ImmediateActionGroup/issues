package com.immediateactiongroup.issues.manager;

import com.immediateactiongroup.issues.model.User;

/**
 * @Author xueshan.wei
 * @Date 2018/7/13 下午8:55
 */
public interface UserManager {

    User selectByUserMobile(String mobile);

    User selectByUserEmail(String email);
}
