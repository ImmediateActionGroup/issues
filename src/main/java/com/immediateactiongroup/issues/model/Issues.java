package com.immediateactiongroup.issues.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
@Entity
public class Issues {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Date createTime;
    private Date lastModifyTime;
    private int status; //issues 状态
    private int priority; // 优先级
    private int storyPoint; //

    private Date dueDate;// 目标完成日期

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private User reporter;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private User assignee;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private User creater;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Project projectb;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private IssuesType issuesType;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Label label;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "issues")
    private List<IssuesHistory> issuesHistoryList = new ArrayList<>();

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

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public Project getProjectb() {
        return projectb;
    }

    public void setProjectb(Project projectb) {
        this.projectb = projectb;
    }

    public IssuesType getIssuesType() {
        return issuesType;
    }

    public void setIssuesType(IssuesType issuesType) {
        this.issuesType = issuesType;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
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

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<IssuesHistory> getIssuesHistoryList() {
        return issuesHistoryList;
    }

    public void setIssuesHistoryList(List<IssuesHistory> issuesHistoryList) {
        this.issuesHistoryList = issuesHistoryList;
    }
}
