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
public class Project {
    private Long id;

    private String name;

    private String description;

    private String projectKey;

    private Long ownerId;

    private Integer deleteFlag;

    private Long createrId;

    private Date lastModifyTime;

    private Date createTime;

}