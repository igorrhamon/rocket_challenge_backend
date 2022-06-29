package org.challenge.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.challenge.model.Person;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public List<Person> allPersons = listAll();
    
    public List<Person> findByNameLike(String name) {
        // Person person =  listAll().stream()
        //         .filter(p -> p.getName().contains(name))
        //         .findFirst()
        //         .orElse(null);
        String searchInput = "%" + name + "%";
        return list("name like ?1", searchInput );

    }


    
}
