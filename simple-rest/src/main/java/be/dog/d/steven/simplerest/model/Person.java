package be.dog.d.steven.simplerest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class Person {

    @JsonProperty("id")
    private final UUID id;

    @JsonProperty("name")
    private final String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
