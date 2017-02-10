package com.eliti.hello.resources.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paranamer.ParanamerOnJacksonAnnotationIntrospector;
import io.restassured.mapper.factory.Jackson2ObjectMapperFactory;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

public class DescartesObjectMapperFactory implements Jackson2ObjectMapperFactory {
  @Override
  public ObjectMapper create(Class aClass, String s) {
        return new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
            .setAnnotationIntrospector(new ParanamerOnJacksonAnnotationIntrospector())
            .setVisibility(FIELD, ANY);
  }
}
