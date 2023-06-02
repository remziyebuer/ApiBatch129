package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
//setUp() methodu ile request isleminde tekrrli yapilacak islemler burada bir
// kez yapilacak.@Test öncesi calismasi icin @Before Annotationu olusturuyoruz.
    protected RequestSpecification spec;

    @Before//Her @Test methodu öncesi calisir
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setAccept(ContentType.JSON)
                .build();







    }
}
