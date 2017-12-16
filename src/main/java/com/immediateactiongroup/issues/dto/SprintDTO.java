package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.Issues;
import com.immediateactiongroup.issues.model.Sprint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by beishan on 2017/6/29.
 */
public class SprintDTO {

    private Long id;
    private String name;
    private Date beginTime;
    private Date endTime;
    private Date createTime;
    private Date lastModifyTime;
    private int status;
    List<IssuesDTO> issuess;

    public SprintDTO() {
    }

    public SprintDTO(Sprint sprint){
        this.id = sprint.getId();
        this.name = sprint.getName();
        this.beginTime = sprint.getBeginTime();
        this.endTime = sprint.getEndTime();
        this.createTime = sprint.getCreateTime();
        this.lastModifyTime = sprint.getLastModifyTime();
        this.status = sprint.getStatus();
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<IssuesDTO> getIssuess() {
        return issuess;
    }

    public void setIssuess(List<IssuesDTO> issuess) {
        this.issuess = issuess;
    }
}
