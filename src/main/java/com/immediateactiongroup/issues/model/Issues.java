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
public class Issues {
    private Long id;

    private Integer status;

    private String title;

    private String storyPoint;

    private Integer priority;

    private String description;

    private Long assignerId;

    private Long assignedUserId;

    private Long createrId;

    private Long reporterId;

    private Long projectId;

    private Integer deleteFlag;

    private Date lastModifyTime;

    private Date createTime;
}