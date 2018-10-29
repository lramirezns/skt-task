package com.skytouch.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {


    public static <T> String objectToJson(T obj, ObjectMapper mapper) {

        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return "An error occurred when the application when trying to convert the object: " + obj.getClass() + " by: " + e.getMessage();
        }
    }

    public static <T> T jsonToObject(String json, Class<T> classType, ObjectMapper mapper) {
        try {
            return mapper.readValue(json, classType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
