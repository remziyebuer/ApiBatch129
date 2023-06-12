package ödev_sorular;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CokluJson {

    /*  Given
           https://petstore.swagger.io/v2/pet/7653
        When
            send the get request
        Then
            Body should be like ;

                       {
             "id": 7653,
             "category": {
               "id": 1,
               "name": "crazycats"
             },
             "name": "buka",
             "photoUrls": [
               "string"
             ],
             "tags": [
               {
                 "id": 0,
                 "name": "string"
               }
             ],
             "status": "available"

     */


    @Test
    public void test01() {
        // 1 - URL ve request body oluştur

        String url = "https://example.com/api/endpoint";
        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("id", 0);
        requestBodyMap.put("name", "doggie");
        requestBodyMap.put("photoUrls", new String[] {"string"});
        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("id", 0);
        categoryMap.put("name", "string");
        requestBodyMap.put("category", categoryMap);
        Map<String, Object> tagMap = new HashMap<>();
        tagMap.put("id", 0);
        tagMap.put("name", "string");
        requestBodyMap.put("tags", new Map[] {tagMap});
        requestBodyMap.put("status", "available");

        // 2 - Expected Data oluştur

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("status", "available");

        // 3 - Response kaydet

        Map<String, Object> responseMap = given()
                .contentType("application/json")
                .body(requestBodyMap)
                .when()
                .put(url)
                .as(HashMap.class);

        // 4 - Assertion

        assertEquals(expectedDataMap.get("status"), responseMap.get("status"));
        assertEquals(requestBodyMap.get("id"), responseMap.get("id"));
        assertEquals(requestBodyMap.get("name"), responseMap.get("name"));
        assertEquals(requestBodyMap.get("photoUrls"), responseMap.get("photoUrls"));
        assertEquals(categoryMap.get("id"), ((Map)responseMap.get("category")).get("id"));
        assertEquals(categoryMap.get("name"), ((Map)responseMap.get("category")).get("name"));
        assertEquals(tagMap.get("id"), ((Map)((Map[])responseMap.get("tags"))[0]).get("id"));
        assertEquals(tagMap.get("name"), ((Map)((Map[])responseMap.get("tags"))[0]).get("name"));
    }
}

