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
public class Sprint {
    private Long id;

    private String name;

    private Integer status;

    private Long projectId;

    private Date beginTime;

    private Date endTime;

    private Integer deleteFlag;

    private Date lastModifyTime;

    private Date createTime;
}