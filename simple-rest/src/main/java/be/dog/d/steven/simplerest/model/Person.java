package be.dog.d.steven.simplerest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    @NotBlank
    private String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
