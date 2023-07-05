package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {


    protected RequestSpecification spec;

    @Before
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://gmibank.com")
                .addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjg4NjYzODIxfQ.Niazl20kECwEFbecagk7cIXg-mK7banxx1ZhIcWqr1YjuFwHzMeA5xpfuTbK_QhDNdkCcbIt4m5ZvcOGptzvRg")
                .build();


    }
}
