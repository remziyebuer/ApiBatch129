package utils;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import pojos.Authpojo;

import static io.restassured.RestAssured.given;

public class CalismaAuthentication {

    public String generateToken(String username, String password, Boolean rememberme){
       //String endpoint = Configurationproperties.getproperty(url);

        Authpojo expectedData =  new Authpojo(username,password,true);

        Response response = given().body(expectedData).post();
       return   response.jsonPath().getString("id_token");
    }
}
