package com.immediateactiongroup.issues.model.dao;

import com.immediateactiongroup.issues.model.SprintIssues;
import com.immediateactiongroup.issues.model.SprintIssuesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SprintIssuesMapper {
    long countByExample(SprintIssuesExample example);

    int deleteByExample(SprintIssuesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SprintIssues record);

    int insertSelective(SprintIssues record);

    List<SprintIssues> selectByExample(SprintIssuesExample example);

    SprintIssues selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SprintIssues record, @Param("example") SprintIssuesExample example);

    int updateByExample(@Param("record") SprintIssues record, @Param("example") SprintIssuesExample example);

    int updateByPrimaryKeySelective(SprintIssues record);

    int updateByPrimaryKey(SprintIssues record);
}