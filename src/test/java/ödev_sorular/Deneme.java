package ödev_sorular;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Deneme extends HerOkuAppBaseUrl {

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
       public void soru04() {
           //Set the Url
           spec.pathParam("first","booking").queryParams("firstname" ,"Josh","lastname", "Allen");


          //Send The Request and Get The Response
           Response response = given(spec).get("{first}");
           response.prettyPrint();

         //response.then().statusCode(200).body("bookingid",hasSize(greaterThan(0)));
         //  Assert.assertFalse(response.asString().isEmpty());
           assertTrue(response.asString().contains("bookingid"));





       }

}
