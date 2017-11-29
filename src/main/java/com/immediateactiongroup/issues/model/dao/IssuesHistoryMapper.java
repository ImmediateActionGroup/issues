package com.immediateactiongroup.issues.model.dao;

import com.immediateactiongroup.issues.model.IssuesHistory;
import com.immediateactiongroup.issues.model.IssuesHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssuesHistoryMapper {
    long countByExample(IssuesHistoryExample example);

    int deleteByExample(IssuesHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssuesHistory record);

    int insertSelective(IssuesHistory record);

    List<IssuesHistory> selectByExample(IssuesHistoryExample example);

    IssuesHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssuesHistory record, @Param("example") IssuesHistoryExample example);

    int updateByExample(@Param("record") IssuesHistory record, @Param("example") IssuesHistoryExample example);

    int updateByPrimaryKeySelective(IssuesHistory record);

    int updateByPrimaryKey(IssuesHistory record);
}