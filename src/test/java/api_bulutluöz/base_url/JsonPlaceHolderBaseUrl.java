package api_bulutluöz.base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {



    protected RequestSpecification specJsonPlace;

    @Before
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com/posts").
                build();

    }


}

