package spring.query.entity;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.matching;

public class ExampleMatcherMatchingWithIgnorePathTest extends QueryExampleTest {

    @Test
    public void matchingWithIgnorePaths() {
        // Arrange
        ExampleMatcher matching = matching()
                // ignora el nombre y el apellido
                // solo va tomar encuenta el id
                .withIgnorePaths("name", "lastName");

        Example<Person> query = Example.of(person1, matching);

        // Act
        // La consulta busca un registro en la tabla de personas que
        // coincida con los campos especificados en el objeto de ejemplo.
        // deben coincidir con los valores de persona1 - solo el id
        Person result = personRepository.findOne(query).get();

        // Assert
        Assert.assertEquals("name1", result.getName());
        Assert.assertEquals("lastName1", result.getLastName());

    }


    @Test
    public void matchingWithIgnorePathsEjemplo2Test() {
        // Arrange
        Person person = new Person("name1", "lastName1");
        person.setId(1L);
        ExampleMatcher matching = matching()
                .withIgnorePaths(
                        "name",
                        "lastName"
                );

        Example<Person> query = Example.of(person, matching);

        // Act
        Person result = personRepository.findOne(query).get();

        // Assert
        Assert.assertEquals("name1", result.getName());
        Assert.assertEquals("lastName1", result.getLastName());

    }

    @Test
    public void matchingWithIgnorePathsEjemplo3Test() {
        // Arrange
        Person person = new Person("name1", "lastName1");
        //person.setId(1L);
        ExampleMatcher matching = matching()
                .withIgnorePaths(
                        "name"
                        //,"lastName"
                );

        Example<Person> query = Example.of(person, matching);

        // Act
        List<Person> result = personRepository.findAll(query);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("name1", result.get(0).getName());
        Assert.assertEquals("lastName1", result.get(0).getLastName());

    }

    @Test
    public void matchingWithIgnorePathsEjemplo4Test() {
        try {
            // Arrange
            Person person = new Person("name1", "lastName1");
            //person.setId(1L);
            ExampleMatcher matching = matching()
                    .withIgnorePaths(
                            //"name"
                            //,"lastName"
                    );
            Example<Person> query = Example.of(person, matching);
            // Act
            List<Person> result = personRepository.findAll(query);
            Assert.fail("Debe generar error...");
        } catch ( Exception e) {
            Assert.assertEquals("IgnoredPaths must not be empty!", e.getLocalizedMessage());
        }

    }

    @Test
    public void matchingWithIgnorePathsEjemplo5Test() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        ExampleMatcher matching = matching()
                .withIgnorePaths(
                        "name",
                        "lastName"
                );

        Example<Person> query = Example.of(person, matching);

        // Act
        Person result = personRepository.findOne(query).get();

        // Assert
        Assert.assertEquals("name1", result.getName());
        Assert.assertEquals("lastName1", result.getLastName());

    }

    @Test
    public void matchingWithIgnorePathsEjemplo6Test() {
        // Arrange
        Person person = new Person();
        ExampleMatcher matching = matching()
                .withIgnorePaths(
                        "name",
                        "lastName"
                );

        Example<Person> query = Example.of(person, matching);

        // Act
        List<Person> result = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(11, result.size());

    }

    @Test
    public void matchingWithIgnorePathsEjemplo7Test() {
        // Arrange
        Person person = new Person();
        ExampleMatcher matching = matching()
                .withIgnorePaths(
                        "id"
                );

        Example<Person> query = Example.of(person, matching);

        // Act
        List<Person> result = personRepository.findAll(query);

        // Assert
        Assert.assertEquals(11, result.size());

    }

}
