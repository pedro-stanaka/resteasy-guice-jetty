package com.eliti.hello.ioc;

import com.eliti.hello.providers.JsonConfig;
import com.eliti.hello.resources.HelloResource;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.fasterxml.jackson.module.paranamer.ParanamerOnJacksonAnnotationIntrospector;
import com.google.inject.Provides;
import org.jboss.resteasy.plugins.guice.ext.RequestScopeModule;

import javax.inject.Singleton;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

public class AppModule extends RequestScopeModule {

  @Override
  protected void configure() {

    super.configure();

    // Resources
    bind(HelloResource.class);

    // Providers
    bind(JsonConfig.class);
  }


  @Provides
  @Singleton
  public ObjectMapper provideMapper() {
    return new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        .setAnnotationIntrospector(new ParanamerOnJacksonAnnotationIntrospector())
        .registerModule(new AfterburnerModule())
        .setVisibility(FIELD, ANY);
  }
}
