package com.immediateactiongroup.issues.dto.validate;

import lombok.Data;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午3:39
 *
 * 用户信息修改
 */
@Data
public class UserUpdateDTO {
    private Long id;
    private String nickname;
}
