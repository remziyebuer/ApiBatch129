package ödev_sorular;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Ödev_HerokuAppSmokeTest extends HerOkuAppBaseUrl {
    /*
   "https://restful-booker.herokuapp.com/apidoc/index.html" dökümanını kullanarak;

    Bir booking oluşturan, o booking'i güncelleyen ve sonra silen ve bu adımları doğrulayan positif ve negatif testler içeren bir otomasyon testi yazınız.

*/
    /*
    Given
          https://restful-booker.herokuapp.com/booking
    And    {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}

    When
         User sends a POST Request to the url
     Then
         HTTP Status Code should be 200
     And
       Body;
{
    "bookingid": 1,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}
     */

    @Test
    public void smokeHerOkuApp(){

       //  1.Set the Url ;
        spec.pathParam("first","booking");

        //2.Set the expected Data

       BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
       BookingPojo expectedData  =  new BookingPojo("Jim", "Brown", 111,
                                   true, bookingDatesPojo, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //3.Send the request and get the response

       Response response =  given(spec).body(expectedData).post("{first}");
       response.prettyPrint();

       //Do Assertion
       BookingResponsePojo actualData = ObjectMapperUtils
                .convertJsonToJava(response.asString(),BookingResponsePojo.class);

        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
       assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
       assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
       assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
       assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
       assertEquals(bookingDatesPojo.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
       assertEquals(bookingDatesPojo.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
       assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());




    }

}
