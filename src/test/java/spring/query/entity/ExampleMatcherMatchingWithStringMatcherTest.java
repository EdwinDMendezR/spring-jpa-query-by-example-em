package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.matching;

public class ExampleMatcherMatchingWithStringMatcherTest  extends QueryExampleTest {

    @Test
    public void matchingWithStringMatcherEnding() {

        // Arrange
        ExampleMatcher matching = matching().withStringMatcher(ExampleMatcher.StringMatcher.ENDING);
        Example<Person> query = Example.of(new Person("0", null), matching);

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(2, resultado.size());
        Assert.assertEquals("name10", resultado.get(0).getName());

    }

    @Test
    public void matchingWithStringMatcherDafault() {

        // Arrange
        ExampleMatcher matching = matching().withStringMatcher(
                // Esto significa que la comparación de cadenas será sensible a mayúsculas y minúsculas
                // y utilizará una coincidencia parcial para comparar cadenas
                ExampleMatcher.StringMatcher.DEFAULT
        );
        Example<Person> query = Example.of(new Person(null, "lastName3"), matching);

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(1, resultado.size());

    }



    @Test
    public void matchingWithStringMatcherExact() {

        // Arrange
        ExampleMatcher matching = matching().withMatcher(
                "lastName", ExampleMatcher.GenericPropertyMatchers.exact()
        );
        Example<Person> query = Example.of(new Person(null, "lastName3"), matching);

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(1, resultado.size());

    }

    @Test
    public void matchingWithStringMatcherExact2() {

        // Arrange
        ExampleMatcher matching = matching()
                .withMatcher(
                "lastName",
                        ExampleMatcher.GenericPropertyMatchers.exact()
                )
                .withMatcher(
                        "name",
                        ExampleMatcher.GenericPropertyMatchers.exact()

                );

        Example<Person> query = Example.of(new Person("name3", "lastName3"), matching);

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(1, resultado.size());

    }




}
