package be.dog.d.steven.simplerest;

import be.dog.d.steven.simplerest.model.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class PersonPojoTest {

    @Test
    public void create() throws Exception{
        UUID id = UUID.randomUUID();
        Person p = new Person(id,"Jane");

        Assert.assertEquals(p.getName(),"Jane");
    }
}
