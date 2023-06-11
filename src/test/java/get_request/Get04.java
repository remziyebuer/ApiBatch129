package get_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {

      /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos => toplam 200 todos olması gerekir
	    And
	        "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir
	    And
	        2, 7, and 9 should be among the userIds => userId değerleri arasında 2, 7 ve 9 bulunmalıdır
     */

    @Test
    public void get04()  {

        //1.Set the Url

        //String url = "https://jsonplaceholder.typicode.com/todos"; ==> Tavsiye edilmeyen yöntem

        spec.pathParam("first", "todos");//spec kullanabilmek icin extends yaptik

        //2.Set tehe expected Data

        //3.Send the request and get the response

        Response response = given(spec).get("{first}");
        response.prettyPrint();

       //Do Assertion
        response.then()
                .statusCode(200)//HTTP Status Code should be 200
                .contentType(ContentType.JSON)//Response format should be "application/json"
                .body("title" , hasSize(200))//There should be 200 todos
                .body("title" , hasItem("quis eius est sint explicabo"))//"quis eius est sint explicabo" should be one of the todos titl
                .body("userId" , hasItems(2,7,9));//2, 7, and 9 should be among the userIds

        //hasSize(); eleman sayisini assert eder
        //hasItem(); methodu contains () gibi tek bir objenin icerilip icerilmedigini assert eder
        //hasItems(); methodu containsAll() gibi coklu objelerin icerilip icerilmediini assert eder

    }
}
