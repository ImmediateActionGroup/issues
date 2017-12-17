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
public class ProjectUser {
    private Long id;

    private Long projectId;

    private Long userId;

    private Integer role;

    private Date lastModifyTime;

    private Date createTime;

    private Byte deleteFlag;
}