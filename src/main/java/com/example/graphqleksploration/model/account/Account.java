package com.example.graphqleksploration.model.account;

import com.example.graphqleksploration.model.project.Project;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany (fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "stars_project",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> starsProject = new HashSet<>();

    @ManyToMany (fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "subscribe_project",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> subscribeProject = new HashSet<>();

    //Project projects;
    public Account(String name) {
        this.name = name;
    }

    public void toogleStarsProject(Project project) {

        if (starsProject.contains(project)) {
            starsProject.remove(project);
        } else {
            starsProject.add(project);
        }
    }

    public void toogleSubsProject(Project project) {
        if (subscribeProject.contains(project)) {
            subscribeProject.remove(project);
        } else {
            subscribeProject.add(project);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
