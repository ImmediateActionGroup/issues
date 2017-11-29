package com.immediateactiongroup.issues.model.dao;

import com.immediateactiongroup.issues.model.IssuesType;
import com.immediateactiongroup.issues.model.IssuesTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssuesTypeMapper {
    long countByExample(IssuesTypeExample example);

    int deleteByExample(IssuesTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssuesType record);

    int insertSelective(IssuesType record);

    List<IssuesType> selectByExample(IssuesTypeExample example);

    IssuesType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssuesType record, @Param("example") IssuesTypeExample example);

    int updateByExample(@Param("record") IssuesType record, @Param("example") IssuesTypeExample example);

    int updateByPrimaryKeySelective(IssuesType record);

    int updateByPrimaryKey(IssuesType record);
}