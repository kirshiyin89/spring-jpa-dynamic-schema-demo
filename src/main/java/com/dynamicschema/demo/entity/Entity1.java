package com.dynamicschema.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ENTITY1", schema = "SCHEMA1_$", catalog = "SCHEMA1_$")
@Data
public class Entity1 {

    @Id
    private Long id;

}
