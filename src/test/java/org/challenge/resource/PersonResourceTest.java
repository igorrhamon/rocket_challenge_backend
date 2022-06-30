package org.challenge.resource;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class PersonResourceTest {

    
    
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
        given().when().get("/person/searchByName/John").then().statusCode(Response.Status.OK.getStatusCode());
    }
    
    @Test
    public void testCreatePerson() {
        

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body("{\"name\":\"John\",\"age\":30}")
        .when()
            .post("/person")
        .then()
            .statusCode(Response.Status.CREATED.getStatusCode());
            
    }
    
}
