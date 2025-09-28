package io.github.lucasfreitasrocha.cine_cli.core.util;


import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterJson {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T fromStringJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to object", e);
        }
    }
}
