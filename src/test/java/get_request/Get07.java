package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {
   /*
      Given
          https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL
      Then
          1)Status code is 200 == > Status kodu 200 olmali
          2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
            Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
          3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini
           konsolunu yazdirin
            Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane
            userId oldugunu dogrulayin
          4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk
            olan datalarin birinin
            basliginin "delectus aut autem" icerdigini dogrulayin
     */

    @Test
    public void get07() {
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();//her seferinde yazdirmasin diye kapattim.

        //Do Assertion

        //Status code is 200
        assertEquals(200, response.statusCode());

        //Print all ids greater than 190 on the console
        JsonPath jsonPath = response.jsonPath();
//        String string = response.asString();
//        string.
        List<Object> list = jsonPath.getList("findAll{it.id>190}.id");
        System.out.println("list = " + list);

        //Assert that there are 10 ids greater than 190
        assertEquals(10, list.size());

        //Print all userIds whose ids are less than 5 on the console
        List<Integer> userIdList = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("userIdList = " + userIdList);

        //Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals(4, userIdList.size());

        //Print all titles whose ids are less than 5
        List<String> titleList = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);

        //Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(titleList.contains("delectus aut autem"));

       //title ' i "ipsam aperiam voluptates qui" olan elemanin id sini bulunuz. yukardaki sorudan bagimsiz
        List<Integer> titleId = jsonPath.getList("findAll{it.title=='ipsam aperiam voluptates qui'}.id");
        System.out.println("titleId = " + titleId);

/*
       Groovy, Java Sanal Makinesi (JVM) üzerinde çalışan bir nesne yönelimli programlama dilidir.
      Groovy, Java diline benzer bir sözdizimine sahiptir ve Java ile sorunsuz bir şekilde entegre
      edilebilir.

       Groovy, Java'yı genişleten ve geliştiren bir dil olarak kabul edilir. Java dilinde bulunmayan
      bazı özelliklere sahiptir ve daha esnek ve ifade odaklı bir sözdizimine sahiptir. Groovy, daha
      az yazı ile daha fazla iş yapmayı ve daha okunabilir kod oluşturmayı hedefler.
 */


    }
}
