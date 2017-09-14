package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.Project;

import java.util.Date;

/**
 * Created by beishan on 2017/6/29.
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public UserDTO getCreater() {
        return creater;
    }

    public void setCreater(UserDTO creater) {
        this.creater = creater;
    }
}
