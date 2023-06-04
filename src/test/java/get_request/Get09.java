package get_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
       /*
      Given
          https://restful-booker.herokuapp.com/booking/411
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
   */

    @Test
    public void get09() {
        //Set the Url
        spec.pathParams("first","booking","second",411);

        //Set the expected Data
        Map<String , String> bookingsDateMap= new HashMap<>();//önce inner Map yapilir
        bookingsDateMap.put("checkin", "2018-01-01");
        bookingsDateMap.put("checkout", "2019-01-01");

        Map<String , Object> expectedData= new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingsDateMap);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);//Json to Java(De -Serialization)

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));

        //*** Value olarak "Object" data tipi dönen değerleri Casting yaparak asıl data türüne
        // çeviriyoruz ve methodlara bu yöntem ile ulaşabiliyoruz.
//        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),
//                ((Map)actualData.get("bookingdates")).get("checkin"));
//        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),
//                ((Map)actualData.get("bookingdates")).get("checkout"));
        assertEquals(bookingsDateMap.get("checkout"),
                ((Map)actualData.get("bookingdates")).get("checkout"));
        assertEquals((bookingsDateMap.get("checkout")),
                ((Map)actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        //Objede get methodu yoktur get childi olan hashmapin methodudur.Map Objenin cocugudur onun methodunu
        // kullanabilmesi icin cast gereklidir*********
       // Object obj = new HashMap<String , String>();
        //obj.get() burdaki get  kirmizi yanar Cün ki yok
        //((Map)obj).get("abc");ancak bu sekilde kullanilir
    }


    @Test
    public void get09DinamikYontem() {
        //Set the Url
        spec.pathParams("first", "booking", "second", 411);

        //Set the expected Data
        HerOkuAppTestData obj = new HerOkuAppTestData();

        Map<String, String> bookingDatesMap = obj.
                bookingdatesMapMethod("2018-01-01", "2019-01-01");

        Map<String, Object> expectedData = obj.expectedDataMapMethod("John", "Smith",
                111, true, bookingDatesMap, "Breakfast");


        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);//Json to Java(De -Serialization)

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkout"),
                ((Map) actualData.get("bookingdates")).get("checkout"));
        assertEquals((bookingDatesMap.get("checkout")),
                ((Map) actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        //value ler objedir benim onlari map e cevirmem cast etmem lazim ki ihtiyacim olan
        // methodlardan faydalanaym
    }

    }
