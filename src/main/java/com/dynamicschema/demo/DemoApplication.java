package com.dynamicschema.demo;

import com.dynamicschema.demo.repository.Entity1Repository;
import com.dynamicschema.demo.repository.Entity2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @EventListener
    public void on(ApplicationReadyEvent event)  {
        entity1Repository.findAll();
        entity2Repository.findAll();
    }
}
