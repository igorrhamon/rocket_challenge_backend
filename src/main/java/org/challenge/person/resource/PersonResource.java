package org.challenge.person.resource;

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

import org.challenge.person.model.Person;
import org.challenge.person.repository.PersonRepository;

@Path("/person")
public class PersonResource {
    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        return Response.status(Response.Status.OK).entity(personRepository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(personRepository.findById(id)).build();
    }

    @GET
    @Path("/searchByName/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPersonByName(@PathParam("name") String name) {
        return Response.status(Response.Status.OK).entity(personRepository.findByNameLike(name)).build();
    }

    @POST
    @Transactional
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(@QueryParam("name") String name) {

        // if(name == null) {
        //     return Response.status(Response.Status.BAD_REQUEST).build();
        // }

        Person person = new Person();
        person.setName(name);
        personRepository.persist(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }
}