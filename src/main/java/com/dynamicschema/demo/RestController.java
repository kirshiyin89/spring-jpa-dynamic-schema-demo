package com.dynamicschema.demo;

import com.dynamicschema.demo.repository.Entity1Repository;
import com.dynamicschema.demo.repository.Entity2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;

    @GetMapping("/all")
    public String getAll() {

        entity1Repository.findAll();
        entity2Repository.findAll();

        return "OK";
    }
}
