package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by beishan on 2017/6/29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssuesDTO {
    private Long                id;
    private String              name;
    private String              description;
    private Date                createTime;
    private Date                lastModifyTime;
    private int                 status; //issues 状态
    private int                 priority; // 优先级
    private int                 storyPoint; //
    private Date                dueDate;// 目标完成日期
    private UserDTO             reporter;
    private UserDTO             assignee;
    private UserDTO             creater;
    private ProjectDTO          project;
    private IssuesTypeDTO       issuesType;
    private LabelDTO            label;
}
