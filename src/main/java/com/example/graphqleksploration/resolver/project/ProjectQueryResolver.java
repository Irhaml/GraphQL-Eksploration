package com.example.graphqleksploration.resolver.project;

import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Component
@Controller
public class ProjectQueryResolver {

    @Autowired
    ProjectService projectService;

    @QueryMapping
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @QueryMapping
    public Project getProject(@Argument int id) {
        return projectService.getProjectById(id);
    }

    @QueryMapping
    public Integer countProjectStar(@Argument int id) {
        return projectService.countProjectStar(id);
    }
}
