package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.*;


import static org.springframework.data.domain.ExampleMatcher.matching;

public class PageableTest extends QueryExampleTest {

    @Test
    public void genericPropertyMatchersContaints() {

        // Arrange
        ExampleMatcher matching = matching().withMatcher(
                "lastName", ExampleMatcher.GenericPropertyMatchers.contains()
        );
        Example<Person> query = Example.of(new Person(null, "lastName"), matching);
        Pageable pageable = PageRequest.of(0, 3);

        // Act
        Page<Person> resultado = personRepository.findAll(query, pageable);

        // Assert
        Assert.assertEquals(4, resultado.getTotalPages());
        Assert.assertEquals(3, resultado.getContent().size());

    }

}
