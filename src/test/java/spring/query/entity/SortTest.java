package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.matching;


public class SortTest extends QueryExampleTest{


    @Test
    public void sortTest() {

        // Arrange
        ExampleMatcher matching = matching().withMatcher(
                "lastName", ExampleMatcher.GenericPropertyMatchers.contains()
        );

        Person person = new Person(null, "lastName");

        Sort sort = Sort.by("lastName").descending();

        Example<Person> query = Example.of(person, matching);

        // Act
        List<Person> resultado = personRepository.findAll(query, sort);

        // Assert
        Assert.assertEquals(11, resultado.size());

    }

}
