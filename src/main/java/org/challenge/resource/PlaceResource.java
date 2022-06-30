package org.challenge.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.challenge.place.model.Place;
import org.challenge.place.respository.PlaceRepository;

@Path("/place")
public class PlaceResource {
    @Inject
    PlaceRepository placeRepository;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPlace() {
        return Response.status(Response.Status.OK).entity(placeRepository.listAll()).build();
    }

    @GET
    @Path("/slug/{slug}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPlaceBySlug(@PathParam("slug") String slug) {
        return Response.status(Response.Status.OK).entity(placeRepository.findBySlug(slug)).build();
    }

    @POST
    @Path("/")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlace(@QueryParam("slug") String slug, @QueryParam("name") String name, @QueryParam("city") String city, @QueryParam("state") String state) {
        Place place = new Place();
        place.setSlug(slug);
        place.setName(name);
        place.setCity(city);
        place.setState(state);
        placeRepository.persist(place);
        return Response.status(Response.Status.CREATED).entity(place).build();
    }
}
