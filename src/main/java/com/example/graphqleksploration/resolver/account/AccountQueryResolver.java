package com.example.graphqleksploration.resolver.account;

import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Component
@Controller
public class AccountQueryResolver {

    @Autowired
    AccountService accountService;

    @QueryMapping
    public Account getAccount(@Argument int id) {
        return accountService.getAccountById(id);
    }

    @QueryMapping
    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }
}
