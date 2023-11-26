package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {

    private String name;
    private int age;
    private String breed;

    Animal(@JsonProperty("name") String name,
           @JsonProperty("age") int age,
           @JsonProperty("breed") String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
}
