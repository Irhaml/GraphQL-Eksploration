package com.example.graphqleksploration.resolver.project;

import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.model.dto.ProjectInput;
import com.example.graphqleksploration.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Slf4j
@Component
@Controller
public class ProjectMutationResolver {

    @Autowired
    ProjectService projectService;

    @MutationMapping
    public Project createProject(@Argument ProjectInput input) {
        return projectService.createProject(input);
    }
}
