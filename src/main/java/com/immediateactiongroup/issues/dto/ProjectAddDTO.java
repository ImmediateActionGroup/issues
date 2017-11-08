package com.immediateactiongroup.issues.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午4:40
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAddDTO {
    private String              name;
    private String              key;
    private String              description;
    //创建人id
    private Long                createrId;
}
