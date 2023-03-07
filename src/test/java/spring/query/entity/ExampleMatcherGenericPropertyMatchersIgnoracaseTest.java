package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.matching;

public class ExampleMatcherGenericPropertyMatchersIgnoracaseTest extends QueryExampleTest {

    @Test
    public void matchingWithStringMatcherDefault2() {

        // Arrange
        ExampleMatcher matching = matching().withMatcher(
                "lastName", ExampleMatcher.GenericPropertyMatchers.ignoreCase()
        );
        Example<Person> query = Example.of(new Person(null, "lastNAME3"), matching);

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(1, resultado.size());

    }

}
