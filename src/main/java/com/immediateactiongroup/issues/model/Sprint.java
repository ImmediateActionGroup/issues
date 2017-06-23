package com.immediateactiongroup.issues.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
@Entity
public class Sprint {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private Date beginTime;
    private Date endTime;
    private Date createTime;
    private Date lastModifyTime;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Project project;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "sprint_issues", joinColumns = {@JoinColumn(name = "sprint_id")},
            inverseJoinColumns = {@JoinColumn(name = "issues_id")})
    private List<Issues> issuesList = new ArrayList<>();

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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Issues> getIssuesList() {
        return issuesList;
    }

    public void setIssuesList(List<Issues> issuesList) {
        this.issuesList = issuesList;
    }
}
