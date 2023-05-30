package get_request;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02 {
   /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be "HTTP/1.1 404 Not Found"
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02() {
        String url ="https://restful-booker.herokuapp.com/booking/0";

        Response response = given().get(url);
        response.prettyPrint();

   //Api de ilk status code test edilir
        response.then()
                .statusCode(404)// HTTP Status code should be 404
                .statusLine("HTTP/1.1 404 Not Found");//Status Line should be "HTTP/1.1 404 Not Found"

      //  Response body contains "Not Found" bunu dogrulamak cvbin icinde onu string olarak al.
           Assert.assertTrue(response.asString().contains("Not Found"));

      // Response body does not contain "TechProEd"(bu da olumsuz senaryo)

         Assert.assertFalse(response.asString().contains("TechProEd"));

      //Server is "Cowboy"
        String server = response.header("Server");
       Assert.assertEquals("Cowboy", server);
    }
}
