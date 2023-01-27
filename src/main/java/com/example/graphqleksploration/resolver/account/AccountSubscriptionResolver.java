package com.example.graphqleksploration.resolver.account;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AccountSubscriptionResolver implements GraphQLSubscriptionResolver {

    @Autowired
    AccountService accountService;

    public Publisher<Project> getSubsProjectUpdate(int id) {
        log.info("Masuk ke Subscribe");
        return accountService.getSubsProjectPublisher(id);
    }


}
