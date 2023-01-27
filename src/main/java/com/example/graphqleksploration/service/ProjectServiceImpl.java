package com.example.graphqleksploration.service;

import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.model.dto.ProjectInput;
import com.example.graphqleksploration.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    AccountService accountService;
    @Autowired
    ProjectRepository projectRepository;


    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(int id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project createProject(ProjectInput input) {
        Account owner = accountService.getAccountById(input.getOwnerId());
        Project project = Project.builder().
                name(input.getName()).
                owner(owner).
                build();

        projectRepository.save(project);
        return project;
    }

    @Override
    public Integer countProjectStar(int id) {
        Project project = getProjectById(id);
        return project.getStarsAccount().size();
    }
}
