package com.immediateactiongroup.issues.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by beishan on 2017/6/27.
 */
@Entity
public class IssuesHistory {
    @Id
    @GeneratedValue
    private Long id;

    private String event;
    private Date time;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private Issues issues;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private User operater;

    @Override
    public String toString() {
        return "IssuesHistory{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", time=" + time +
                ", issues=" + issues +
                ", operater=" + operater +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Issues getIssues() {
        return issues;
    }

    public void setIssues(Issues issues) {
        this.issues = issues;
    }

    public User getOperater() {
        return operater;
    }

    public void setOperater(User operater) {
        this.operater = operater;
    }
}
