package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    //<T> T --> Herhangi bir data tipini temsil eder.
   //readValue() methodu birinci parametrede belirtilen
   // String json datayı ikinci parametrede belirtilen data tipine çevirir.
public static <V> V convertJsonToJava(String json, Class <V>cls)  {// Bu bir Generic Method'tur.

    try {
        return new ObjectMapper().readValue(json , cls);

    } catch (JsonProcessingException e) {

        throw new RuntimeException(e);
    }

}

















}
