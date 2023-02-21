package com.example.graphqleksploration.resolver.issue;

import com.example.graphqleksploration.model.issue.Issue;
import com.example.graphqleksploration.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
@Component
@Controller
public class IssueQueryResolver {

    @Autowired
    IssueService issueService;

    @QueryMapping
    public List<Issue> getAllIssue(@Argument int projectId) {
        return issueService.getAllIssue(projectId);
    }
}
