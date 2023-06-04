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
        bookingsDateMap.put("checkin", "checkin");
        bookingsDateMap.put("checkout", "checkout");

                return bookingsDateMap;

}

    public Map<String, Object> expectedDataMapMethod(String firstname, String lastname , int totalprice,
                                                     boolean depositpaid,
                                                     Map<String , String> bookingsDateMap,String additionalneeds) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingsDateMap);
        if(additionalneeds !=null) {
            expectedData.put("additionalneeds", additionalneeds);
        }

        return expectedData;
    }
}
