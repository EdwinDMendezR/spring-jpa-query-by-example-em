package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.query.entity.Person;
import spring.query.entity.PersonRepository;
import spring.query.entity.QueryPerson;

@SpringBootApplication
public class SpringQueryApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringQueryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person person1 = new Person("name1", "lastName1");
        Person person2 = new Person("name2", "lastName2");
        Person person3 = new Person("name3", "lastName3");
        Person person4 = new Person("name4", "lastName4");
        Person person5 = new Person("name5", "lastName5");
        Person person6 = new Person("name6", "lastName6");
        Person person7 = new Person("name7", "lastName7");
        Person person8 = new Person("name8", "lastName8");
        Person person9 = new Person("name9", "lastName9");
        Person person10 = new Person("name10", "lastName10");
        QueryPerson person11 = new QueryPerson("name10", "lastName10");


//        personRepository.save(person1);
//        personRepository.save(person2);
//        personRepository.save(person3);
//        personRepository.save(person4);
//        personRepository.save(person5);
//        personRepository.save(person6);
//        personRepository.save(person7);
//        personRepository.save(person8);
//        personRepository.save(person9);
//        personRepository.save(person10);
//        personRepository.save(person10);
//        personRepository.save(person11);
    }
}
