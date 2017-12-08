package com.immediateactiongroup.issues.dto;

import com.immediateactiongroup.issues.model.IssuesType;

/**
 * Created by beishan on 2017/6/29.
 */
public class IssuesTypeDTO {
    private Long id;
    private String name;
    private String icon;

    public IssuesTypeDTO(IssuesType issuesType) {
        this.id = issuesType.getId();
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
