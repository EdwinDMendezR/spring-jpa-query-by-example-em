package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;


import static org.springframework.data.domain.ExampleMatcher.matching;

public class CountTest extends QueryExampleTest {

    @Test
    public void genericPropertyMatchersContaints() {

        // Arrange
        ExampleMatcher matching = matching().withMatcher(
                "lastName", ExampleMatcher.GenericPropertyMatchers.contains()
        );
        Example<Person> query = Example.of(new Person(null, "lastName"), matching);

        // Act
        long resultado = personRepository.count(query);

        // Assert
        Assert.assertEquals(11, resultado);

    }

}
