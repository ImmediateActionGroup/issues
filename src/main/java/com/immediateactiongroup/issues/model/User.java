package com.immediateactiongroup.issues.model;

import com.immediateactiongroup.issues.commons.constant.UserConstant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/6/17.
 */
@Entity
public class User implements UserDetails{

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private int enable;
    private Date createTime;
    private Date lastModifyTime;
    private Date lastLoginTime;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "project_user", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<Project> projects = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "creater")
    private List<Issues> issuesList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "assignee")
    private List<Issues> assignIssuesList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "reporter")
    private List<Issues> reporterIssuesList = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "operater")
    private List<IssuesHistory> issuesHistories = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<Role> roles = this.getRoles();
        for(Role role : roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    public User() {
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        Date now = new Date();
        this.createTime = now;
        this.lastLoginTime = now;
        this.lastModifyTime = now;
        this.enable = UserConstant.UserAccess.ENABLE.getValue();
        this.nickname = "don't have nickname";
        this.getRoles().add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Issues> getIssuesList() {
        return issuesList;
    }

    public void setIssuesList(List<Issues> issuesList) {
        this.issuesList = issuesList;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Issues> getAssignIssuesList() {
        return assignIssuesList;
    }

    public void setAssignIssuesList(List<Issues> assignIssuesList) {
        this.assignIssuesList = assignIssuesList;
    }

    public List<Issues> getReporterIssuesList() {
        return reporterIssuesList;
    }

    public void setReporterIssuesList(List<Issues> reporterIssuesList) {
        this.reporterIssuesList = reporterIssuesList;
    }

    public List<IssuesHistory> getIssuesHistories() {
        return issuesHistories;
    }

    public void setIssuesHistories(List<IssuesHistory> issuesHistories) {
        this.issuesHistories = issuesHistories;
    }
}
