package com.dynamicschema.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ENTITY2", schema = "SCHEMA2_$", catalog = "SCHEMA2_$")
@Data
public class Entity2 {

    @Id
    private Long id;

}