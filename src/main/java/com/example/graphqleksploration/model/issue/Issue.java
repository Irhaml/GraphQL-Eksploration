package com.example.graphqleksploration.model.issue;

import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.model.project.Project;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

//    @ManyToOne (fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "parent_issue", nullable = true)
//    private Issue parentIssue;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "project_issue", nullable = false)
    private Project projectIssue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
