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
public class IssuesLabel {
    private Long id;

    private Long issuesId;

    private Long labelId;

    private Date lastModifyTime;

    private Date createTime;

    private Integer deleteFlag;
}