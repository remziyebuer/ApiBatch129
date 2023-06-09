package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
       /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */
//Patch pojo ile sorun oluyor map daha iyi ****************
    @Test//Patch request ==> Kısmı güncelleme(Put)
    public void patch01() {
        //Set the url
        spec.pathParams("first", "todos", "second", 198);

         //Set the expected data

        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
       Map<String , Object> expectedData =  obj.expectedDataMapMetHod(null, "Wash the dishes", null);
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Tüm data assert edilecekse böyle normalde kullanmiyorum
        expectedData.put("userId" ,  10);
        expectedData.put("completed" ,  true);


        //Do assertion
        Map<String , Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("title"), actualData.get("title"));


        //Tüm data assert edilecekse
//        //1.yol
//        assertEquals(10, actualData.get("userId"));//obje ile bir data karsilastirilabilir
//        // eger data türü ayni ise cun ki obje classinda equals methodu var
//        assertEquals(true , actualData.get("completed"));//ya da ben hard coding kullanmak istemiyorsam

        //2.yol expected data ma put yapabilirim.

    }
}
