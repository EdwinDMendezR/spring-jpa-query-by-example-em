package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import static org.springframework.data.domain.ExampleMatcher.matching;

public class MatchingWithMatcherStartsWithTest extends  QueryExampleTest {

    @Test
    public void matchingWithMatcherIgnoreCase() {

        // Arrange
        ExampleMatcher matching = matching()
                //.withIgnorePaths("age")
                .withMatcher("name", startsWith())
                .withMatcher("lastName", ignoreCase());

        Example<Person> query = Example.of(
                new Person("name1", "LASTNAME1"),
                matching
        );


        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(1, resultado.size());

    }


    @Test
    public void matchingWithMatcherExampleMatcher() {

        // Arrange
        ExampleMatcher matching = matching()
                //.withIgnorePaths("age")
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::startsWith)
                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatcher::ignoreCase);

        Example<Person> query = Example.of(
                new Person("name1", "LASTNAME1"),
                matching
        );

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(1, resultado.size());

    }

}
