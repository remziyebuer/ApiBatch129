package patch_request;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

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

    @Test//Patch request ==> Kısmı güncelleme(Put)
    public void patch01() {
        //Set the url
        spec.pathParams("first", "todos", "second", 198);

         //Set the expected data



        //Send the request and get the response



        //Tüm data assert edilecekse


        //Do assertion


        //Tüm data assert edilecekse

    }
}
