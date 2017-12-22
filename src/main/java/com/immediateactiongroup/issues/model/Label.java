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
public class Label {
    private Long id;

    private String name;

    private Long projectId;

    private Integer systemFlag;

    private Date lastModifyTime;

    private Date createTime;

    private Integer deleteFlag;
}