package api_bulutluöz.test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class API_GetRequest {

       /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir
        GET request yolladigimizda donen Response’in

        status code'unun 200,
        ve content type'inin JSON,
        ve response body'sinde bulunan userId'nin 5,
        ve response body'sinde bulunan title'in "optio dolor molestias sit"
        			oldugunu test edin.
         */

    @Test
    public void get01() {

        // 1- Request URL ve Body olustur

        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Expected Data olustur

        JSONObject expBody = new JSONObject();

        expBody.put("userId",5);
        expBody.put("title","optio dolor molestias sit");

        // 3 - Responsu kaydet

        Response response = given().when().get(url);

        // response.prettyPrint();

        // 4 - Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath actBody = response.jsonPath();

        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));
        Assert.assertEquals(expBody.get("title"),actBody.get("title"));


    }

    public static class API_PostBulutluöz {
        @Test
        public void post01(){
            /*
        https://jsonplaceholder.typicode.com/posts  URL’ine
        asagidaki body ile bir POST request gonderdigimizde
        {
         "title":"API",
         "body":"API ogrenmek ne guzel",
         "userId":10,
         }
         donen Response’un,
         status code’unun 201,
         ve content type’inin application/json
         ve Response Body'sinin id haric,
         {
         "title":"API",
         "body":"API ogrenmek ne guzel",
         "userId":10,
         }
         oldugunu test edin.
         */

            // 1 - Request URL ve body olustur

            String url = "https://jsonplaceholder.typicode.com/posts";

            JSONObject reqBody = new JSONObject();

            reqBody.put("title", "API");
            reqBody.put("body", "API ogrenmek ne guzel");
            reqBody.put("userId", 10);

            // 2 - Expected Data olustur

            JSONObject expBody = new JSONObject();

            expBody.put("title", "API");
            expBody.put("body", "API ogrenmek ne guzel");
            expBody.put("userId", 10);

            // 3 - Response kaydet

            Response response = given().
                    contentType(ContentType.JSON).
                    when().
                    body(reqBody.toString()).
                    post(url);

            JsonPath actBody = response.jsonPath();

            // 4 - Assertion

            response.
                    then().
                    assertThat().
                    contentType(ContentType.JSON).
                    statusCode(201);

            Assert.assertEquals(expBody.get("title"),actBody.get("title"));
            Assert.assertEquals(expBody.get("body"),actBody.get("body"));
            Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));


        }

    }
}
