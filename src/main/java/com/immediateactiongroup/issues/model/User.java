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
public class User {
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Date lastLoginTime;

    private Integer deleteFlag;

    private Date lastModifyTime;

    private Date createTime;
}