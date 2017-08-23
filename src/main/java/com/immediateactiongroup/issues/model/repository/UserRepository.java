package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll();
}
