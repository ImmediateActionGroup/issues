package com.immediateactiongroup.issues.model.dao;

import com.immediateactiongroup.issues.model.IssuesLabel;
import com.immediateactiongroup.issues.model.IssuesLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssuesLabelMapper {
    long countByExample(IssuesLabelExample example);

    int deleteByExample(IssuesLabelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IssuesLabel record);

    int insertSelective(IssuesLabel record);

    List<IssuesLabel> selectByExample(IssuesLabelExample example);

    IssuesLabel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IssuesLabel record, @Param("example") IssuesLabelExample example);

    int updateByExample(@Param("record") IssuesLabel record, @Param("example") IssuesLabelExample example);

    int updateByPrimaryKeySelective(IssuesLabel record);

    int updateByPrimaryKey(IssuesLabel record);
}