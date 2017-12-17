package com.immediateactiongroup.issues.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SprintIssues {
    private Long id;

    private Long sprintId;

    private Long issuesId;

    private Date lastModifyTime;

    private Date createTime;

    private Integer deleteFlag;
}