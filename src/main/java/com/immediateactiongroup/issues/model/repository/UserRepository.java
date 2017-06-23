package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by beishan on 2017/6/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
