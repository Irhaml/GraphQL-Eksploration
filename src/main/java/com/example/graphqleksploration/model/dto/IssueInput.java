package com.example.graphqleksploration.model.dto;

import lombok.Data;

@Data
public class IssueInput {
    String title;
    String description;
    int parentIssueId;
    int projectId;
}
