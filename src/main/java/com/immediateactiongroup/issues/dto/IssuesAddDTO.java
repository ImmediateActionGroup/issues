package com.immediateactiongroup.issues.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author xueshan.wei@mljr.com
 * @Date 2017/11/10 下午11:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssuesAddDTO {
    // issues title
    private String              name;
    // issues 描述
    private String              description;
    // 创建者id
    private Long                createrId;
    // 项目id
    private Long                projectId;
    // 优先级
    private Integer             priority;
    // 目标完成时间
    private Date                dueDate;
    // 报告者id
    private Long                reporterId;
    // 分配给谁的id
    private Long                assingedToUserId;
    // story point
    private Integer             storyPoint;
}
