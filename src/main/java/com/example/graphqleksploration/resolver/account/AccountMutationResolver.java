package com.example.graphqleksploration.resolver.account;

import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.model.dto.AccountInput;
import com.example.graphqleksploration.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class AccountMutationResolver{

    @Autowired
    AccountService accountService;

    @MutationMapping
    public Account createAccount(@Argument AccountInput input) {
        var account = accountService.createAccount(input);
        return account;
    }

    @MutationMapping
    public Account toogleStarProject(@Argument int accountId, @Argument int projectId) {
        return accountService.toogleStarProject(accountId, projectId);
    }

    @MutationMapping
    public Account toogleSubsProject(@Argument int accountId, @Argument int projectId) {
        return accountService.toogleSubsProject(accountId, projectId);
    }
}
