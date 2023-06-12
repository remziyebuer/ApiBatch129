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
	        "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından
	         en az birinin "quis eius est sint explicabo" olması gerekir
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
                .body("id" , hasSize(200))//There should be 200 todos//"" yaparsak tüm datayi döner sadece id yaparsak
                // tüm id leri döner
                .body("title" , hasItem("quis eius est sint explicabo"))//"quis eius est sint explicabo" should be
                // one of the todos titl
                .body("userId" , hasItems(2,7,9));//2, 7, and 9 should be among the userIds

        //hasSize(); eleman sayisini assert eder
        //hasItem(); methodu contains () gibi tek bir objenin icerilip icerilmedigini assert eder
        //hasItems(); methodu containsAll() gibi coklu objelerin icerilip icerilmediini assert eder


        /*
        Matcher'lar, test ifadelerini daha okunabilir ve anlaşılır hale getirmek için kullanılır. Bir değerin
      veya bir nesnenin belirli bir koşulu karşılamasını kontrol etmek için kullanılırlar. Örneğin, bir
      sayının belirli bir değerden büyük olup olmadığını kontrol etmek, bir metin içerisinde belirli bir
      deseni aramak veya bir nesnenin belirli bir özelliğe sahip olup olmadığını doğrulamak için matcherlar
      kullanılabilir.

Matcher'lar, genellikle belirli bir kütüphane veya araç setine ait olurlar. Örneğin, Java dilinde popüler
olarak kullanılan Hamcrest Matchers, geniş bir matcher koleksiyonuna sahip bir doğrulama kütüphanesidir.
Hamcrest Matchers, ifade odaklı test ifadeleri oluşturmayı sağlar ve özelleştirilebilir matcher'lar sunar.

Örneğin, equalTo(), greaterThan(), containsString() gibi Hamcrest Matchers'ın sağladığı matcher'lar, bir
değerin belirli bir değerle eşleşip eşleşmediğini, büyüklük ilişkilerini veya bir metin içinde belirli bir
deseni içerip içermediğini kontrol etmek için kullanılabilir.

Matcher'lar, testlerin okunabilirliğini artırır ve daha açıklayıcı test ifadeleri oluşturmanıza yardımcı olur. Aynı zamanda, testlerin daha esnek olmasını sağlar ve test koşullarının kolayca değiştirilmesine olanak tanır.
         */

    }
}
