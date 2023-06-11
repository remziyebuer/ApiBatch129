package get_request;

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
        c) Otomasyon kodlarını yazma:
            i) Set the URL --> Endpoint'i kur
            ii) Set the expected data --> Beklenen veriyi kur
            iii) Send the request and get the response --> Request yolla, response al
            iv) Do Assertion --> Doğrulama yap
     */

        String url = "https://petstore.swagger.io/v2/pet/4546456654";
        Response response = given().get(url);//import static io.restassured.RestAssured.given;
        response.prettyPrint();//prettyPrint() methodu ile response'ı konsola yazdırdık. kodun kendisi yazdirilir
        System.out.println("****************************");

        //Status Code nasil yazilir?
        System.out.println("Status Code = " + response.statusCode());//getstatusCode de ayni seyi verir
        System.out.println("****************************");

        //Content Type nasıl yazdırılır:
        System.out.println("Content Type = " + response.contentType());
        System.out.println("****************************");

        //Status Line nasıl yazdırılır:
        System.out.println("Status line = " + response.statusLine());
        System.out.println("****************************");

        //Header nasıl yazdırılır:
        System.out.println("Headerlari key value seklinde yazdirir");
        System.out.println("Date = " + response.header("Date"));//Tue, 30 May 2023 21:15:08 GMT
        System.out.println("Connection  = " + response.header("Connection"));
        System.out.println("Server = " + response.header("Server"));
        System.out.println("Transfer-Encoding = " + response.header("Transfer-Encoding"));
        System.out.println("****************************");

        //Headers nasıl yazdırılır:
        System.out.println("----Headers-----");
        System.out.println(response.headers());

        //Time nasıl yazdırılır
        System.out.println("****************************");
        System.out.println("Time = " + response.time());
    }

}
