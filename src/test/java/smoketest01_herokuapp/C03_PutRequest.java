package smoketest01_herokuapp;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static smoketest01_herokuapp.C01_PostRequest.bookingid;

public class C03_PutRequest extends HerOkuAppBaseUrl {
     /*
    Given
      https://restful-booker.herokuapp.com/booking/:id
     And
     {
    "firstname" : "Ali",
    "lastname" : "Can",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
     When
         User sends a PUT Request to the url
     Then
         HTTP Status Code should be 200
     And
       Body;

{
        "firstname": "Ali",
        "lastname": "Can",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }


     */

    @Test
    public void smokeTestPut() {
        //Set the Url
        spec.pathParams("first", "booking", "second", bookingid);

      //Set the expected Data

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Ali", "Can", 111,
                true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

      //Send The Request Get the Response//put icin header a cookie ile token eklenmeli
      Response response =  given(spec).body(expectedData).put("{first}/{second}");
      response.prettyPrint();

        //Do Assertion
        BookingPojo actualData =
                ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname() , actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());












    }
}
