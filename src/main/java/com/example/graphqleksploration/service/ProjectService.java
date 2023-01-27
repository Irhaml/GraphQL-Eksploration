package com.example.graphqleksploration.service;

import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.model.dto.ProjectInput;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();
    Project getProjectById(int id);

    Project createProject(ProjectInput input);

    Integer countProjectStar(int id);
}
