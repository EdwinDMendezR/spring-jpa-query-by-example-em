package spring.query.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private final String name;
    private final String lastName;

}
