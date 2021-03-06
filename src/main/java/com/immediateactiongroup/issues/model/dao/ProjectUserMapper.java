package com.immediateactiongroup.issues.model.dao;

import com.immediateactiongroup.issues.model.ProjectUser;
import com.immediateactiongroup.issues.model.ProjectUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectUserMapper {
    long countByExample(ProjectUserExample example);

    int deleteByExample(ProjectUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectUser record);

    int insertSelective(ProjectUser record);

    List<ProjectUser> selectByExample(ProjectUserExample example);

    ProjectUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectUser record, @Param("example") ProjectUserExample example);

    int updateByExample(@Param("record") ProjectUser record, @Param("example") ProjectUserExample example);

    int updateByPrimaryKeySelective(ProjectUser record);

    int updateByPrimaryKey(ProjectUser record);
}