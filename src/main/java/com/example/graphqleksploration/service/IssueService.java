package com.example.graphqleksploration.service;

import com.example.graphqleksploration.model.dto.IssueInput;
import com.example.graphqleksploration.model.issue.Issue;

import java.util.List;

public interface IssueService {
    List<Issue> getAllIssue(int projectId);

    Issue createIssue(IssueInput input);
}
