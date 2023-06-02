package postrequest;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }

             shift + tab tusu  ile body kopyaladiktan sonr a geriye alma düzeltme postman de
     */

    @Test //String ile post yapmak kolaydir ama assert icin tavsiye edilmez.cün ki hard kod kullanmamaliyiz.
    public void post01() {//test specten dolayi junit olmak zorunda

        //Set the url
        spec.pathParam("first","todos");

        //Set the expected Data => Json datayi stringe cevirerek java objesi olarak kullaniyoruz.
        // Yapmazsak Json kullanamayz yollayamayz.cun ki biz java dili kullaniyoruz.json api kullandigi dil.
        String payload = "{\n" +
                " \"userId\": 55,\n" +
                " \"title\": \"Tidy your room\",\n" +
                " \"completed\": false\n" +
                "  }";

        //Send the request and get the response
        Response response = given(spec).body(payload).post("{first}");//body metodunda java kullanmaliyiz
        response.prettyPrint();

         //Do Assertion
        assertEquals(201, response.statusCode());




    }
}
