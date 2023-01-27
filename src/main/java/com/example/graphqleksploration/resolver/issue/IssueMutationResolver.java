package com.example.graphqleksploration.resolver.issue;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqleksploration.model.dto.IssueInput;
import com.example.graphqleksploration.model.issue.Issue;
import com.example.graphqleksploration.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IssueMutationResolver implements GraphQLMutationResolver {

    @Autowired
    IssueService issueService;

    public Issue createIssue(IssueInput input) {
        return issueService.createIssue(input);
    }

}
