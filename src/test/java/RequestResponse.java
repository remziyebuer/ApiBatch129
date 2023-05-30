import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {

         /*
    1) Postman manual test için kullanılır
    2) API otomasyonu için Rest-Assured Library kullanıyoruz
    3) Otomasyon kodlarının yazımı için şu adımların izlenmesi gerekir:
        a) Gereksinimleri anlama
        b) Test Case'i yazma:
            -Test yazmak için 'Gherkin Language' kullanıyoruz.
            x) Given: Ön koşullar --> Enpoint, Body ...
            y) When: Yapılacak işlemler --> Get, Put, Delete ...
            z) Then: Dönütler --> Assertion, Close ...
            t) And:  Art arda kullanılan aynı işlemler için and kullanılır
        c) Otomasyon kolarının yazma:
            i) Set the URL --> Endpoint'i kur
            ii) Set the expected data --> Beklenen veriyi kur
            iii) Send the request and get the response --> Request yolla, response al
            iv) Do Assertion --> Doğrulama yap
     */

      String url = "https://petstore.swagger.io/v2/pet/4546456654";
      Response response =  given().get(url);
      response.prettyPrint();






    }

}
