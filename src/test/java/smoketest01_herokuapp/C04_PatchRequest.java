package smoketest01_herokuapp;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static smoketest01_herokuapp.C01_PostRequest.bookingid;

public class C04_PatchRequest extends HerOkuAppBaseUrl {
      /*
    Given
      https://restful-booker.herokuapp.com/booking/:id
     And
     {
     "totalprice": 555,
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
        "totalprice": 555,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Lunch"
    }


     */

    @Test
    public void smokeTestPatch() {//map tavsiye edilir Patchte

        //Set the url
        spec.pathParams("first", "booking", "second", bookingid);

        //Set the expected Data
        Map<String, Object> expectedData = new HerOkuAppTestData()
                .expectedDataMapMethod(null, null, 555, null,
                        null, "Lunch");
        System.out.println("expectedData = " + expectedData);

        //Send The Request Get The Response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get( "additionalneeds"), actualData.get( "additionalneeds"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));


    }
}
