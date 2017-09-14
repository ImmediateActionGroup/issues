package com.immediateactiongroup.issues.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by beishan on 2017/6/17.
 */
@Entity
@Table(name = "project_user")
@Data
public class ProjectUser {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Date joinTime;

    private Integer role;

}
