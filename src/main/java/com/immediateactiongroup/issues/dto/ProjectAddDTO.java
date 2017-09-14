package com.immediateactiongroup.issues.dto;

import lombok.Data;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/9/14 下午4:40
 */
@Data
public class ProjectAddDTO {
    private String              name;
    private String              key;
    private String              description;
    //创建人id
    private Long                createrId;
}
