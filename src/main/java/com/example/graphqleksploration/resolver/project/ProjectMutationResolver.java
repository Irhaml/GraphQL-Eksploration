package com.example.graphqleksploration.resolver.project;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.model.dto.ProjectInput;
import com.example.graphqleksploration.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProjectMutationResolver implements GraphQLMutationResolver {

    @Autowired
    ProjectService projectService;

    public Project createProject(ProjectInput input) {
        return projectService.createProject(input);
    }
}
