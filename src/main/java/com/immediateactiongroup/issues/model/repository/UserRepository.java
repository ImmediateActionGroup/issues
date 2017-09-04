package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll();

    User findById(Long id);

    @Query("select u.id from User as u where u.id = ?1")
    Long existUserById(Long id);

    void deleteById(Long id);
}
