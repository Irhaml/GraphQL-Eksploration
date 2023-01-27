package com.example.graphqleksploration.resolver.account;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.model.dto.AccountInput;
import com.example.graphqleksploration.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMutationResolver implements GraphQLMutationResolver {

    @Autowired
    AccountService accountService;

    public Account createAccount(AccountInput input) {
        var account = accountService.createAccount(input);
        return account;
    }

    public Account toogleStarProject(int accountId, int projectId) {
        return accountService.toogleStarProject(accountId, projectId);
    }

    public Account toogleSubsProject(int accountId, int projectId) {
        return accountService.toogleSubsProject(accountId, projectId);
    }
}
