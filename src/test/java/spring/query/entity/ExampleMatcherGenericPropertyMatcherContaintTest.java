package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.matching;

public class ExampleMatcherGenericPropertyMatcherContaintTest extends QueryExampleTest {


    @Test
    public void genericPropertyMatchersContaints() {

        // Arrange
        ExampleMatcher matching = matching().withMatcher(
                "lastName", ExampleMatcher.GenericPropertyMatchers.contains()
        );
        Example<Person> query = Example.of(new Person(null, "lastName"), matching);

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(11, resultado.size());

    }

}
