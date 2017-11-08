package com.immediateactiongroup.issues.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/10/26 下午1:26
 * 批量删除用户参数
 */
@Data
@AllArgsConstructor
public class BatchDeleteUserDTO {

    private Long [] ids;
}
