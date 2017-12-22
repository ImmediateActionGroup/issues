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
public class UserRole {
    private Long id;

    private Date lastModifyTime;

    private Date createTime;

    private Long userId;

    private Long roleId;

    private Integer deleteFlag;
}