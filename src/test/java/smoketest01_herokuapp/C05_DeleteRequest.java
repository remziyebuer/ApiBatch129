package smoketest01_herokuapp;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static smoketest01_herokuapp.C01_PostRequest.bookingid;

public class C05_DeleteRequest extends HerOkuAppBaseUrl {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/:id
    When
    Send Delete Request
    Then
    Status Code is 201
    And
    Response Body;
    Created

     */

    @Test
    public void smokeTestDelete() {

        //Set the Url
        spec.pathParams("first","booking","second", bookingid);

        //Set the expected Data
        String expectedData = "Created";

        //Send The Request Get The Response
        Response response =   given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData, response.asString());
    }
}
