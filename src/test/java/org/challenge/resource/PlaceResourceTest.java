
package org.challenge.resource;


import org.challenge.place.model.Place;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PlaceResourceTest {
    
    @Test
    public void testGetPlace() {
        given().when().get("/place").then().statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void testGetPlaceBySlug() {
        given().contentType(MediaType.APPLICATION_JSON).when().get("/place/slug/sao-paulo").then().statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void testGetPlaceByID(){
        given().contentType(MediaType.APPLICATION_JSON).when().get("/place/1").then().statusCode(Response.Status.OK.getStatusCode());
    }

    // @Test
    // public void testCreatePlace() {
        
        
    //     given()
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .body("{\"slug\":\"sao-paulo\",\"name\":\"São Paulo\",\"city\":\"São Paulo\",\"state\":\"SP\"}")
    //         .when()
    //         .post("/place")
    //         .then()
    //         .statusCode(Response.Status.CREATED.getStatusCode());
    // }
    @Test
    public void testCreatePlace() {
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body("{\"slug\":\"sao-paulo\",\"name\":\"São Paulo\",\"city\":\"São Paulo\",\"state\":\"SP\"}")
        .when()
            .post("/place")
        .then()
            .statusCode(Response.Status.CREATED.getStatusCode());
            
    }

}
