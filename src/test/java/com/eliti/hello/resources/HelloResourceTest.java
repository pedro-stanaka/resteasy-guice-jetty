package com.eliti.hello.resources;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.awt.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HelloResourceTest {

  @Before
  public void setUp() throws Exception {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = 8888;
  }

  @Test
  public void hello() throws Exception {
    given()
      .accept(MediaType.APPLICATION_JSON)
      .pathParam("name", "World")
      .when()
      .get("/hello/{name}")
      .then()
      .body("message", is(equalTo("Hello World!")));
  }

}
