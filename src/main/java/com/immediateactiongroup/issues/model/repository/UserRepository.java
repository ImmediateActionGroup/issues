package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll();

    User findById(Long id);

    @Query("select u.id from User as u where u.id = ?1")
    Long existUserById(Long id);

    void deleteById(Long id);

    Page<User> queryAll(Pageable pageable);
}
