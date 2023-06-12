package smoketest01_herokuapp;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

import static smoketest01_herokuapp.C01_PostRequest.bookingid;

public class C04_PatchRequest extends HerOkuAppBaseUrl {
      /*
    Given
      https://restful-booker.herokuapp.com/booking/:id
     And
     {
    "additionalneeds" : "Lunch"
      }
     When
         User sends a PATCH Request to the url
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
        "additionalneeds": "Lunch"
    }


     */

    @Test
    public void smokeTestPatch() {
        spec.pathParams("first","booking","second", bookingid);

    }
}
