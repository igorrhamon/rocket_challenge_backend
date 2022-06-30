package org.challenge.place.respository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.challenge.place.model.Place;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PlaceRepository implements PanacheRepository<Place> {

    public List<Place> findBySlug(String slug) {
        String searchInput = "%" + slug + "%";
        return list("name like ?1", searchInput );

    }
    

}
