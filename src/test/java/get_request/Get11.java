package get_request;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

public class Get11 extends HerOkuAppBaseUrl {
       /*
        Given
            https://restful-booker.herokuapp.com/booking/11
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
 		              {
                        "firstname": "John",
                        "lastname": "Smith",
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
    public void get11() {
        //Set the url
        spec.pathParams("first", "booking","second","11");

        //Set the expected data






    }
}
