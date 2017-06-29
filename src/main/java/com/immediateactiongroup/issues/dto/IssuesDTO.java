package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.User;

import java.util.Date;

/**
 * Created by beishan on 2017/6/29.
 */
public class IssuesDTO {
    private Long id;
    private String name;
    private String description;
    private Date createTime;
    private Date lastModifyTime;
    private int status; //issues 状态
    private int priority; // 优先级
    private int storyPoint; //
    private Date dueDate;// 目标完成日期
    private UserDTO reporter;
    private UserDTO assignee;
    private UserDTO creater;
    private ProjectDTO project;
    private IssuesTypeDTO issuesType;
    private LabelDTO label;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(int storyPoint) {
        this.storyPoint = storyPoint;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public UserDTO getReporter() {
        return reporter;
    }

    public void setReporter(UserDTO reporter) {
        this.reporter = reporter;
    }

    public UserDTO getAssignee() {
        return assignee;
    }

    public void setAssignee(UserDTO assignee) {
        this.assignee = assignee;
    }

    public UserDTO getCreater() {
        return creater;
    }

    public void setCreater(UserDTO creater) {
        this.creater = creater;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public IssuesTypeDTO getIssuesType() {
        return issuesType;
    }

    public void setIssuesType(IssuesTypeDTO issuesType) {
        this.issuesType = issuesType;
    }

    public LabelDTO getLabel() {
        return label;
    }

    public void setLabel(LabelDTO label) {
        this.label = label;
    }
}
