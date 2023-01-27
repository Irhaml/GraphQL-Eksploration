package com.example.graphqleksploration.repository;

import com.example.graphqleksploration.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
