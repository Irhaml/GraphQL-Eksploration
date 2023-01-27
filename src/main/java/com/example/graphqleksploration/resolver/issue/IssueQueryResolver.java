package com.example.graphqleksploration.resolver.issue;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqleksploration.model.issue.Issue;
import com.example.graphqleksploration.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class IssueQueryResolver implements GraphQLQueryResolver {

    @Autowired
    IssueService issueService;

    public List<Issue> getAllIssue(int projectId) {
        return issueService.getAllIssue(projectId);
    }
}
