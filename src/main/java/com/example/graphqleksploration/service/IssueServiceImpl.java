package com.example.graphqleksploration.service;

import com.example.graphqleksploration.model.dto.IssueInput;
import com.example.graphqleksploration.model.issue.Issue;
import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.repository.IssueRepository;
import com.example.graphqleksploration.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IssueServiceImpl implements IssueService{
    @Autowired
    IssueRepository issueRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Issue> getAllIssue(int projectId) {
        return issueRepository.findAllByProjectIssue_Id(projectId);
    }

    @Override
    public Issue createIssue(IssueInput input) {
        Project parentProject = projectRepository.findById(input.getProjectId()).get();
//        Issue parentIssue = issueRepository.getById(input.getParentIssueId());

        Issue issue = Issue.builder()
                .title(input.getTitle())
                .description(input.getDescription())
                .projectIssue(parentProject)
                .build();

//        if (parentIssue != null) {
//            issue.setParentIssue(parentIssue);
//        }

        issueRepository.save(issue);
        return issue;
    }
}
