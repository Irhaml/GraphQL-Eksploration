package com.example.graphqleksploration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@ComponentScan({"com.example.graphqleksploration.resolver", "com.example.graphqleksploration.service","com.example.graphqleksploration.publisher"})
@EntityScan("com.example.graphqleksploration.model")
@EnableJpaRepositories("com.example.graphqleksploration.repository")
public class GraphQlEksplorationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlEksplorationApplication.class, args);
    }

}
