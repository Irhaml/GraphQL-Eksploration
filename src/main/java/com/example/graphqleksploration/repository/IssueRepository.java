package com.example.graphqleksploration.repository;

import com.example.graphqleksploration.model.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
    List<Issue> findAllByProjectIssue_Id(int id);
}
