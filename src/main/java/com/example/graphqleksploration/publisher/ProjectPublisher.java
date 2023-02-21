package com.example.graphqleksploration.publisher;

import com.example.graphqleksploration.model.account.Account;
import com.example.graphqleksploration.model.project.Project;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;
//import reactor.core.publisher.Sinks;
//import reactor.core.publisher.Sinks.EmitResult;

@Component
@Slf4j
public class ProjectPublisher {

//    private final Sinks.Many sink;
    private final FluxProcessor<Project, Project> processor;
    private final FluxSink<Project> sink;


    public ProjectPublisher() {
//        this.sink = Sinks.many().multicast().onBackpressureBuffer();
        this.processor = DirectProcessor.<Project>create().serialize();
        this.sink = processor.sink();
    }

    public void publish(Project project) {
//        EmitResult result = sink.tryEmitNext(project);
//
//        if (result.isFailure()) {
//            log.error("Failed to publish update message");
//            log.info(result.name());
//        }
        sink.next(project);
    }


    public Publisher<Project> getSubsProjectPublisher(Account account) {
//        return sink.asFlux()
//                .filter(project -> account.getSubscribeProject().contains(project))
//                .map(project -> {
//                    log.info("Publishing project {}", project);
//                    return project;
//                });
        return processor
                .filter(project -> account.getSubscribeProject().contains(project))
                .map(project -> {
                    log.info("Publishing project {}", project);
                    return project;
                });
    }
}
