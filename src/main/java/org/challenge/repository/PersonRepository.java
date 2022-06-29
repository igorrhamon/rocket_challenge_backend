package org.challenge.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.challenge.model.Person;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public List<Person> allPersons = listAll();


    
}
