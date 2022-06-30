package org.challenge.resource;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.function.UnaryOperator;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PersonResourceTest {
    private static final UnaryOperator<String> PERSON = person ->  String.format("{\"name\":\"%s\"}", person);
    
    
    @Test
    public void testGetPerson() {
        given().when().get("/person").then().statusCode(Response.Status.OK.getStatusCode());
    }
    
    @Test
    public void testGetPersonById() {
        given().when().get("/person/1").then().statusCode(Response.Status.OK.getStatusCode());
    }
    
    @Test
    public void testGetPersonByName() {
        given()
        .when()
            .get("/person/searchByName/John")
        .then()
            .statusCode(Response.Status.OK.getStatusCode());
    }
    @Test
    public void testCreatePerson() {
        String person1 = "João";
        String person2 = "João 2";
        String person3 = "João 3";

        Arrays.asList(person1, person2, person3).forEach(person -> {
                given()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                    .body(PERSON.apply(person))
                    .when().post("/person")
                    .then()
                    .statusCode(201);
            }
        );

    }
    
}
