package com.example.graphqleksploration.resolver.account;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class AccountQueryResolver implements GraphQLQueryResolver {

    @Autowired
    AccountService accountService;

    public Account getAccount(int id) {
        return accountService.getAccountById(id);
    }

    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }
}
