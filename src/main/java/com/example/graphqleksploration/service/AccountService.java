package com.example.graphqleksploration.service;

import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.model.dto.AccountInput;
import com.example.graphqleksploration.model.project.Project;
import org.reactivestreams.Publisher;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    Account getAccountById(int id);
    Account createAccount(AccountInput input);

    Publisher<Project> getSubsProjectPublisher(int id);

    Account toogleStarProject(int accountId, int projectId);

    Account toogleSubsProject(int accountId, int projectId);
}
