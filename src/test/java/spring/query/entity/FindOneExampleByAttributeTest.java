package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;

import java.util.List;

public class FindOneExampleByAttributeTest extends QueryExampleTest{

    @Test
    public void queryPerson() {

        // Arrange
        List<Person> resultado = personRepository.findAll();
        Example<Person> query = Example.of(new Person(null, "lastName3"));

        // Act
        Person result = personRepository.findOne(query).get();

        // Assert
        Assert.assertEquals("name3", result.getName());

    }


}
