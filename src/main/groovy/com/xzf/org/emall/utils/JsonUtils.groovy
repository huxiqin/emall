package com.xzf.org.emall.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.transform.CompileStatic

@CompileStatic
class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();


    static String toJson(Object obj){
        objectMapper.writeValueAsString(obj)
    }



    static <T> T parser(String json,Class<T> clazz){
        objectMapper.readerFor(clazz).readValue(json)
    }


}
