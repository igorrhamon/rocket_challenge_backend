
package org.challenge.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.challenge.place.model.Place;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

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
        RequestSpecification requestSpec = new RequestSpecBuilder().build();


        Place place = new Place();
        place.setSlug("sao-paulo");
        place.setName("São Paulo");
        place.setCity("São Paulo");
        place.setState("SP");

        Place placePosted = given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(place)
            .when()
            .post("/place")
            .then()
                .statusCode(201)
                .extract()
                .body().as(Place.class);
        assertNotNull(placePosted);
        Log.info(placePosted.toString());
        System.out.println(placePosted.toString());
        assertEquals(place.getSlug(), placePosted.getSlug());
        


        // Place[] placesFound = given()
        //     .contentType(MediaType.APPLICATION_JSON)
        // .when()
        //     .get("/place/slug/sao-paulo")
        // .then()
        //     .statusCode(Response.Status.OK.getStatusCode())
        //     .statusCode(200)
        //     .extract()
        //     .body().as(Place[].class);
        
        
            
        
    }

}
