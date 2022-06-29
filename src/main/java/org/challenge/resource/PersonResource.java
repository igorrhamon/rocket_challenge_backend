package org.challenge.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.challenge.model.Person;
import org.challenge.repository.PersonRepository;

@Path("/person")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        return Response.status(Response.Status.CREATED).entity(personRepository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") Long id) {
        return Response.status(Response.Status.CREATED).entity(personRepository.findById(id)).build();
    }

    @GET
    @Path("/searchByName/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonByName(@PathParam("name") String name) {
        return Response.status(Response.Status.CREATED).entity(personRepository.searchByNameLike(name)).build();
    }

    @POST
    @Transactional
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(@QueryParam("name") String name) {
        Person person = new Person();
        person.setName(name);
        personRepository.persist(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }
}
