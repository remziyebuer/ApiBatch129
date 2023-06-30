package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

/*
 Map<String , Object> bookingsDateMap= new HashMap<>();//önce inner Map yapilir
        bookingsDateMap.put("checkin", "2018-01-01");
        bookingsDateMap.put("checkout", "2019-01-01");

        Map<String , Object> expectedData= new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingsDateMap);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println("expectedData = " + expectedData);


 */
public Map<String, String> bookingdatesMapMethod(String checkin, String checkout) {

    Map<String , String> bookingsDateMap= new HashMap<>();
        bookingsDateMap.put("checkin", checkin);
        bookingsDateMap.put("checkout", checkout);

                return bookingsDateMap;

}

    public Map<String, Object> expectedDataMapMethod(String firstname, String lastname ,
                                                     Integer totalprice, Boolean depositpaid,
                                                     Map<String , String> bookingsDateMap,
                                                     String additionalneeds) {

        Map<String, Object> expectedData = new HashMap<>();

        if(firstname !=null) {
            expectedData.put("firstname", firstname);
        }
        if(lastname !=null) {
            expectedData.put("lastname", lastname);
        }
        if(totalprice !=null) {
            expectedData.put("totalprice", totalprice);
        }
        if(depositpaid !=null) {
            expectedData.put("depositpaid", depositpaid);
        }
        if( bookingsDateMap !=null) {
            expectedData.put("bookingdates", bookingsDateMap);
        }

        if(additionalneeds !=null) {
            expectedData.put("additionalneeds", additionalneeds);
        }

        return expectedData;
    }








}
