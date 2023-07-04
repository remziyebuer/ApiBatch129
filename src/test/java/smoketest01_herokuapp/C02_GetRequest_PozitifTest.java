package smoketest01_herokuapp;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static smoketest01_herokuapp.C01_PostRequest.bookingid;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class C02_GetRequest_PozitifTest extends HerOkuAppBaseUrl {
     /*
    Given
     https://restful-booker.herokuapp.com/booking/:id
     When
         User sends a GET Request to the url
     Then
         HTTP Status Code should be 200
     And
       Body;

{
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


     */

    @Test
    public void smokeTestGetPozitiv() {//böylece pozitif testimizi olusturmus olduk

        //Set the Url
        spec.pathParams("first","booking","second", bookingid);

        //Set the expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData =  new BookingPojo( "Jim", "Brown", 111, true,
              bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send The Request Get the Response
        Response response =   given(spec).get("{first}/{second}");
        response.prettyPrint();//su an bunu calistirdigimda not found alirim cün ki su an id '0'
        //id nin bir deger alabilmesi icin önce post request class i calismali****
        //o yüzden benim runner class a ihtiyacim var.


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
