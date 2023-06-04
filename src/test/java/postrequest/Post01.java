package postrequest;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

        //Set the expected Data => Json datayi stringe cevirerek java objesi olarak kullaniyoruz.****
        // Yapmazsak Json kullanamayz yollayamayz.cun ki biz java dili kullaniyoruz.json api kullandigi dil.
        String payload = "{\n" +
                " \"userId\": 55,\n" +
                " \"title\": \"Tidy your room\",\n" +
                " \"completed\": false\n" +
                "  }";

        //Send the request and get the response
        Response response = given(spec).body(payload).post("{first}");//request body metodunda
        // java kullanmaliyiz
        response.prettyPrint();//content type mutlaka olmali spec'e ekledik

         //Do Assertion =>biz su ana kadar assert e hard kod kullandik
        JsonPath  jsonpath = response.jsonPath();
        assertEquals(201, response.statusCode());
        assertEquals(55, jsonpath.getInt("userId"));
        assertFalse(jsonpath.getBoolean("completed"));

    }

    @Test
    public void post01Map(){
        //Set the Url
        spec.pathParam("first","todos");

        //Set the expected Data(map bir java objesi)
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 55 );
        expectedData.put("title", "Tidy your room");
        expectedData.put("completed",false );
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response//bunu yapmasi icin jackson ekledik
        Response response = given(spec).body(expectedData).post("{first}");//
        // Serialization islemi yapildi; Java objesi Jackon vasitasi ile Json a cevrildi
        response.prettyPrint();

        //Do Assertion => su an  kod kullandik
        Map<String, Object> actualData = response.as(HashMap.class);
        // De - Serialization islemi yapildi; Json Data  Jackon vasitasi ile Java objesi'ne cevrildi

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));


    }
}
