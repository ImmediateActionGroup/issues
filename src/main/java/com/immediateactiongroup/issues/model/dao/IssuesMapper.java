package com.immediateactiongroup.issues.model.dao;

import com.immediateactiongroup.issues.model.Issues;
import com.immediateactiongroup.issues.model.IssuesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssuesMapper {
    long countByExample(IssuesExample example);

    int deleteByExample(IssuesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Issues record);

    int insertSelective(Issues record);

    List<Issues> selectByExample(IssuesExample example);

    Issues selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Issues record, @Param("example") IssuesExample example);

    int updateByExample(@Param("record") Issues record, @Param("example") IssuesExample example);

    int updateByPrimaryKeySelective(Issues record);

    int updateByPrimaryKey(Issues record);
}