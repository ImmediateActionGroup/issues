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
public class IssuesHistory {
    private Long id;

    private String eventValue;

    private String eventName;

    private Long operaterId;

    private Integer deleteFlag;

    private Date lastModifyTime;

    private Date createTime;
}