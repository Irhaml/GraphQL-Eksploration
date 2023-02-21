package com.example.graphqleksploration.resolver.account;

import com.example.graphqleksploration.model.project.Project;
import com.example.graphqleksploration.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Slf4j
@Component
@Controller
public class AccountSubscriptionResolver {

    @Autowired
    AccountService accountService;

    @SubscriptionMapping
    public Publisher<Project> getSubsProjectUpdate(@Argument int id) {
        log.info("Masuk ke Subscribe");
        return accountService.getSubsProjectPublisher(id);
    }


}
