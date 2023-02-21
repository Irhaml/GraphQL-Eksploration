package com.example.graphqleksploration.resolver.issue;

import com.example.graphqleksploration.model.dto.IssueInput;
import com.example.graphqleksploration.model.issue.Issue;
import com.example.graphqleksploration.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class IssueMutationResolver {

    @Autowired
    IssueService issueService;

    @MutationMapping
    public Issue createIssue(@Argument IssueInput input) {
        return issueService.createIssue(input);
    }

}
