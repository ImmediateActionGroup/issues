package com.immediateactiongroup.issues.model.repository;

import com.immediateactiongroup.issues.model.IssuesHistory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by beishan on 2017/6/27.
 */
public interface IssuesHistoryRepository extends CrudRepository<IssuesHistory, Long> {
}
