package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.IssuesApplicationTests;
import com.immediateactiongroup.issues.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/4 上午11:20
 */
public class UserRepositoryTest extends IssuesApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testExistUserById(){
        Long existUserId = userRepository.existUserById(1L);
        Long notExistUserId = userRepository.existUserById(9999L);
        boolean [] actuals = {existUserId != null , notExistUserId == null};
        boolean [] expecteds = {true, true};
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testDeleteUserById(){
        userRepository.deleteById(5L);
    }
}
