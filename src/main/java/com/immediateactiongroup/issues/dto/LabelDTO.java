package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.Label;

import java.util.Date;

/**
 * Created by beishan on 2017/6/29.
 */
public class LabelDTO {
    private Long id;
    private String name;
    private Date createTime;
    private Date lastModifyTime;

    public LabelDTO(Label label){
        this.id = label.getId();
        this.name = label.getName();
        this.createTime = label.getCreateTime();
        this.lastModifyTime = label.getLastModifyTime();
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
}
