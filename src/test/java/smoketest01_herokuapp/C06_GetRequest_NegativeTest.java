package smoketest01_herokuapp;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static smoketest01_herokuapp.C01_PostRequest.bookingid;

public class C06_GetRequest_NegativeTest  extends HerOkuAppBaseUrl {
     /*
    Given
    https://restful-booker.herokuapp.com/booking/:id
    When
    Send Get Request
    Then
    Status Code is 404
    And
    Response Body is "Not Found"
*/

    @Test
    public void smokeTestGetNegative() {
        //Set the Url
        spec.pathParams("first","booking","second", bookingid);

        //Set the expected Data
        String expectedData = "Not Found";

        //Send The Request Get The Response
        Response response =   given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(404,response.statusCode());
        assertEquals(expectedData, response.asString());
    }
}
