package com.example.graphqleksploration.model.project;

import com.example.graphqleksploration.model.account.Account;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "owner", nullable = false)
    private Account owner;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "starsProject")
    private Set<Account> starsAccount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
