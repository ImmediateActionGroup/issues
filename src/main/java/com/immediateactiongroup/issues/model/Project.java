package com.immediateactiongroup.issues.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
@Entity
@ToString
public class Project {

    @Id
    @GeneratedValue
    private Long                id;
    private String              name;
    private String              projectKey;
    private String              description;
    private Date                createTime;
    private Date                lastModifyTime;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private User                creater;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "project_user", joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> members = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "project")
    private List<Label> labels = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "projectb")
    private List<Issues> issuesList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "project")
    private List<IssuesType> issuesTypes = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "project")
    private List<Sprint> sprints = new ArrayList<>();

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

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<Issues> getIssuesList() {
        return issuesList;
    }

    public void setIssuesList(List<Issues> issuesList) {
        this.issuesList = issuesList;
    }

    public List<IssuesType> getIssuesTypes() {
        return issuesTypes;
    }

    public void setIssuesTypes(List<IssuesType> issuesTypes) {
        this.issuesTypes = issuesTypes;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }
}
