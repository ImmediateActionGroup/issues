package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.Issues;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by beishan on 2017/6/17.
 */
public interface IssuesRepository extends CrudRepository<Issues, Long> {

}
