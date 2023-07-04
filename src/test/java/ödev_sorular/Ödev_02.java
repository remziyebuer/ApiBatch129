package ödev_sorular;


import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Ödev_02 extends HerOkuAppBaseUrl {
//1)

       /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Josh&lastname=Allen  ==> Data değişebilir
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Josh" and lastname is "Allen"   ==> Data değişebilir

     */

        @Test
        public void get04(){
//Set the Url
            spec.pathParam("first","booking").queryParams("firstname","Josh","lastname","Allen");

//Set The Expected Data

//Send The Request and Get The Response
            Response response = given().spec(spec).when().get("/{first}");
            response.prettyPrint();

//Do Assertion
            assertEquals(200,response.statusCode());
            assertTrue(response.asString().contains("bookingid"));

        }



//2)



     /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */


        @Test
        public void get05(){
//Set the Url
            spec.pathParams("first","unknown","second",3);

//Set The Expected Data


//Send The Request and Get The Response
            Response response = given().spec(spec).when().get("/{first}/{second}");
            response.prettyPrint();

//Do Assertion
            SoftAssert softAssert = new SoftAssert();
            JsonPath jsonPath = response.jsonPath();

            softAssert.assertEquals(response.getStatusCode(),200);
            softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
            softAssert.assertEquals(jsonPath.getInt("data.id"),3,"Id degeri dogru degil");
            softAssert.assertEquals(jsonPath.getString("data.name"),"true red", "Name degeri dogru degil");
            softAssert.assertEquals(jsonPath.getInt("data.year"),2002, "year degeri dogru degil");
            softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932", "color degeri dogru degil");
            softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664", "pantone_value degeri dogru degil");
            softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading", "url degeri dogru degil");
            softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!", "text degeri dogru degil");

            softAssert.assertAll();
        }



}
