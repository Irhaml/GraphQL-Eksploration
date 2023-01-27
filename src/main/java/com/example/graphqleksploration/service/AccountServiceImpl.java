package com.example.graphqleksploration.service;

import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.model.dto.AccountInput;
import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.publisher.ProjectPublisher;
import com.example.graphqleksploration.repository.AccountRepository;
import com.example.graphqleksploration.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectPublisher projectPublisher;

    @Override
    public Account getAccountById(int id) {
        return accountRepository.findAccountByIdAndStarsProject(id);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account createAccount(AccountInput input) {
        Set<Project> emptySubsProject = new HashSet<>();
        Set<Project> emptyStarsProject = new HashSet<>();
        Account account =  Account.builder().
                name(input.getName()).
                starsProject(emptyStarsProject).
                subscribeProject(emptySubsProject).
                build();

        accountRepository.save(account);
        return account;
    }

    @Override
    public Publisher<Project> getSubsProjectPublisher(int id) {
        Account account = getAccountById(id);
        return projectPublisher.getSubsProjectPublisher(account);
    }

    @Override
    public Account toogleStarProject(int accountId, int projectId) {
        Project project = projectRepository.findById(projectId).get();
        Account account = getAccountById(accountId);

        account.toogleStarsProject(project);

        accountRepository.save(account);
        projectPublisher.publish(project);
        return account;
    }

    @Override
    public Account toogleSubsProject(int accountId, int projectId) {
        Project project = projectRepository.findById(projectId).get();
        Account account = getAccountById(accountId);

        account.toogleSubsProject(project);

        accountRepository.save(account);
        projectPublisher.publish(project);
        return account;
    }
}
