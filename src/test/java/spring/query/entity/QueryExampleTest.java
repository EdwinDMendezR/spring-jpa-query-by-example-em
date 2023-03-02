package spring.query.entity;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import static org.springframework.data.domain.ExampleMatcher.matching;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {})
@ActiveProfiles("entity-person")
@AutoConfigureMockMvc
public class QueryExampleTest {

    @Autowired
    PersonRepository personRepository;

    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;
    Person person6;
    Person person7;
    Person person8;
    Person person9;
    Person person10;
    QueryPerson person11;
    QueryPerson person12;
    Person person13;

    @Before
    @Transactional
    public void setUp() {
        person1 = new Person("name1", "lastName1");
        person2 = new Person("name2", "lastName2");
        person3 = new Person("name3", "lastName3");
        person4 = new Person("name4", "lastName4");
        person5 = new Person("name5", "lastName5");
        person6 = new Person("name6", "lastName6");
        person7 = new Person("name7", "lastName7");
        person8 = new Person("name8", "lastName8");
        person9 = new Person("name9", "lastName9");
        person10 = new Person("name10", "lastName10");
        person11 = new QueryPerson("name10", "lastName10");
        person12 = new QueryPerson("name10", "LASTNAME10");
        person13 = new Person("name10", "LASTNAME10");


        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.save(person5);
        personRepository.save(person6);
        personRepository.save(person7);
        personRepository.save(person8);
        personRepository.save(person9);
        personRepository.save(person10);
        personRepository.save(person10);

        //  persistencia de tipos múltiples con una columna "DTYPE"
        personRepository.save(person11);

    }

    @Test
    public void queryPerson() {

        // Arrange
        List<Person> resultado = personRepository.findAll();
        Example<Person> query = Example.of(new Person(null, "lastName10"));

        // Act
        Person result = personRepository.findOne(query).get();

        // Assert
        Assert.assertEquals("name10", result.getName());

    }


    @Test
    public void methodTest() {

        // Arrange
        Example<QueryPerson> query = Example.of(new QueryPerson("name10", "lastName10"));

        // Act
        Person result = personRepository.findOne(query).get();

        // Assert
        Assert.assertEquals("name10", result.getName());

    }


    @Test
    public void matchingWithIgnorePaths() {

        // Arrange
        ExampleMatcher matching = matching().withIgnorePaths("name", "lastName");
        Example<Person> query = Example.of(person1, matching);

        // Act
        Person result = personRepository.findOne(query).get();

        // Assert
        Assert.assertEquals("name1", result.getName());

    }


    @Test
    public void matchingWithStringMatcherEnding() {

        // Arrange
        ExampleMatcher matching = matching().withStringMatcher(ExampleMatcher.StringMatcher.ENDING);
        Example<Person> query = Example.of(new Person("0", null), matching);

        // Act
        List<Person> resultado = personRepository.findAll(query);

        // Assert
        Assert.assertEquals("name10", resultado.get(0).getName());

    }


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

    }


    @Test
    public void methodTestd() {

        // Arrange
        ExampleMatcher matching = matching()
                .withMatcher("id", matcher -> matcher.transform(value -> Optional.of(1)));

        Example<Person> query = Example.of(new Person(null, "lastName1"));

        // Act
        List<Person> resultado = personRepository.findAll(query);         

        // Assert

    }


}
