package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    /*
     Map<String , Object> expectedData = new HashMap<>();

        expectedData.put("userId", 21 );
        expectedData.put("title", "Wash the dishes");
        expectedData.put("completed",false );
        System.out.println("expectedData = " + expectedData);

     */

    public Map<String , Object> expectedDataMapMetHod(Integer userId, String title , Boolean completed ){

        Map<String , Object> expectedData = new HashMap<>();

        if(userId != null) { //parametre önceden int id ama int null alamaz o yüzden onu Integer
           // wrapper classina cevirdik ayni sekilde boolean 'i da Boolean olarak degistirdik.
           expectedData.put("userId", userId);
        }

       if (title!= null) {
           expectedData.put("title", title);
       }

       if (completed != null) {
           expectedData.put("completed", completed);
       }

       return expectedData;
    }//bu methodu patch te de kullanabilmek icin sonradan if ekledik daha dinamik oldu artik patch
    // te de kullanabilirim.







}
