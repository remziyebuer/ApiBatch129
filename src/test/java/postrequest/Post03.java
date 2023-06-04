package postrequest;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
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
     */


    @Test
    public void post03() {
        //Set the url
        spec.pathParam("first","todos");

        //Set the expected data(pojo classindan obje olusturuyoruz)

        JsonPlaceHolderPojo expectedData  = new JsonPlaceHolderPojo(55,"Tidy your room", false);
        //bunun maplere göre dezavataji istediginiz kadar veri sonradan giremezsiniz
        // map lerde put deyip giriyorduk burda giremeyiz.illa istiyorsak yeni bir pojo
        // class acmaliyiz. öyle bir kosul varsa map kullanmaliyiz

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion

        JsonPlaceHolderPojo actualData  = response.as(JsonPlaceHolderPojo.class);
   //pojo classimizda default const.olmasaydi de-serilization islemi yapilamazdi
   //eger default const.silip calistirirsak konsolda bu hata acikca yazar

   //karsidan gelen taninmayan field lari ignor etmemiz lazim ki sadece tanidiklarini
   // alsin bu yüzden de Pojo classin basina @JsonIgnoreProperties annotaion koyacagiz

        //artik sadece tanidiklarimiz var karsilastirma yapabiliriz
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());

   //pojo class olusturup object mapper ile okumak en cok tercih edilen yöntem.






    }
}
