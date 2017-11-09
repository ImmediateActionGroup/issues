package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
public interface ProjectRepository extends CrudRepository<Project, Long>{

    Project findByNameAndProjectKey(String name, String key);

    Project findByName(String name);

    Project findByProjectKey(String key);

    Project findByNameOrProjectKey(String name, String key);

    List<Project> findAllByNameOrProjectKey(String name, String key);
}
