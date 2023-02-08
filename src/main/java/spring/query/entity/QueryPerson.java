package spring.query.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class QueryPerson extends Person {

    //private String add = "1X";

    public QueryPerson(String name, String lastName) {
        super(name, lastName);
    }

}
