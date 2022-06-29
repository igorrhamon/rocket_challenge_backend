package org.challenge.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.challenge.model.Place;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PlaceRepository implements PanacheRepository<Place> {

    public List<Place> findBySlug(String slug) {
        String searchInput = "%" + slug + "%";
        return list("name like ?1", searchInput );

    }
    

}
