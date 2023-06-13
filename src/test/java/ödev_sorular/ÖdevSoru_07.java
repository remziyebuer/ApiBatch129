package ödev_sorular;

import base_urls.RegresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ÖdevSoru_07 extends RegresBaseUrl {
     /*
        Given
            1) https://reqres.in/api/users
            2){
                "name": "morpheus",
                "job": "leader"
                }


        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

//    @Test
//    public void post01() {
//     spec.pathParam("first", "users");
//
//        HerOkuAppTestData herOkuAppTestData = new HerOkuAppTestData();
//     //  Map<String , Object >  expectedData= herOkuAppTestData.hamitGül("morpheus","leader");
//
//
//        Response response =  given(spec).body(expectedData).post("{first}");
//        response.prettyPrint();
//
//
//
//      Map<String, Object> actualData = response.as(HashMap.class);
//        System.out.println("actualData = " + actualData);
//
//        assertEquals(201,response.statusCode());
//
//        assertEquals(expectedData.get("name"),actualData.get("name"));
//        assertEquals(expectedData.get("job"),actualData.get("job"));
//
//
//
//
//
//
//}
//




    }

