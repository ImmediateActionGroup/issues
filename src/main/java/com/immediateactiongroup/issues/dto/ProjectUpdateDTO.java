package com.immediateactiongroup.issues.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/16 下午7:25
 */

@Data
@AllArgsConstructor
public class ProjectUpdateDTO {
    private Long projectId;
    private String description;
}
