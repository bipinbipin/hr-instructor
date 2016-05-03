package com.astontech.hr.rest;

import com.astontech.hr.domain.Project;
import com.astontech.hr.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bipin on 4/26/2016.
 */
@RestController
@RequestMapping("/rest/project")
public class ProjectRest {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/list")
    public Iterable<Project> listAllProjects() {
        return projectService.listAllProjects();
    }

    @RequestMapping("/save")
    public Project saveProject(Project project) {
        return projectService.saveProject(project);
    }
}
