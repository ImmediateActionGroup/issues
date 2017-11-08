package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.Sprint;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by beishan on 2017/6/17.
 */
public interface SprintRepository extends CrudRepository<Sprint, Long>{
    Iterable<Sprint> findAllById(Long id);

    Iterable<Sprint> findAllByProjectId(Long projectId);
}
