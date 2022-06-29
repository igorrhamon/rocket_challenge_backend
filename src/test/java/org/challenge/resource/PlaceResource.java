
package org.challenge.resource;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PlaceResource {
    
    @Test
    public void testGetPlace() {
        given().when().get("/place").then().statusCode(Response.Status.OK.getStatusCode());
    }
}
