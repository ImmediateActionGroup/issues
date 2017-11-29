package com.immediateactiongroup.issues.model.dao;

import com.immediateactiongroup.issues.model.Sprint;
import com.immediateactiongroup.issues.model.SprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SprintMapper {
    long countByExample(SprintExample example);

    int deleteByExample(SprintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sprint record);

    int insertSelective(Sprint record);

    List<Sprint> selectByExample(SprintExample example);

    Sprint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sprint record, @Param("example") SprintExample example);

    int updateByExample(@Param("record") Sprint record, @Param("example") SprintExample example);

    int updateByPrimaryKeySelective(Sprint record);

    int updateByPrimaryKey(Sprint record);
}