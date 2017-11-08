package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by beishan on 2017/6/29.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    private String name;
    private String projectKey;
    private String description;
    private Date createTime;
    private Date lastModifyTime;
    private UserDTO creater;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.projectKey = project.getProjectKey();
        this.description = project.getDescription();
        this.createTime = project.getCreateTime();
        this.lastModifyTime = project.getLastModifyTime();
    }
}
