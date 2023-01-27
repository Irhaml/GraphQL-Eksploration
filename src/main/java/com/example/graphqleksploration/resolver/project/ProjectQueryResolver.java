package com.example.graphqleksploration.resolver.project;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProjectQueryResolver implements GraphQLQueryResolver {

    @Autowired
    ProjectService projectService;

    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    public Project getProject(int id) {
        return projectService.getProjectById(id);
    }

    public Integer countProjectStar(int id) {
        return projectService.countProjectStar(id);
    }
}
