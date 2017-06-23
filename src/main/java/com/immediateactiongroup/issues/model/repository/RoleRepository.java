package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by beishan on 2017/6/17.
 */
public interface RoleRepository extends CrudRepository<Role, Long>{

    Role findByName(String name);
}
