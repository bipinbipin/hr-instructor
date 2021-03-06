package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bipin on 3/25/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee extends Person {

    private String background;

    @OneToMany
    private List<Project> projects;

    public Employee() {}

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
