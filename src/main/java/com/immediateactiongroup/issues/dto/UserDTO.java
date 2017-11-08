package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Created by beishan on 2017/6/29.
 * 用户信息DTO类
 */
@Data
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String nickname;
    private String username;
    private int enable;
    private Date createTime;
    private Date lastModifyTime;
    private Date lastLoginTime;

    public static UserDTO build(Long id, String nickname,
                                String username, int enable, Date createTime,
                                Date  lastModifyTime, Date lastLoginTime){
        return new UserDTO(id, nickname, username, enable, createTime, lastModifyTime, lastLoginTime);
    }

    public UserDTO(User user){
        this.createTime = user.getCreateTime();
        this.lastLoginTime = user.getLastLoginTime();
        this.lastModifyTime = user.getLastModifyTime();
        this.enable = user.getEnable();
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.username = user.getUsername();
    }
}
