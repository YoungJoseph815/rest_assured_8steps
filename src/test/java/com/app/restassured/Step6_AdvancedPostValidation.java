package com.app.restassured;

import com.app.restassured.pojo.Book;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

public class Step6_AdvancedPostValidation {

    // serialization and deserialization
    //extract()
    // payload  body()
    // Gson
    // 3 types of Assertions  hamcrest/Junit hard assertion/restassuted then()


    Response response;

    //TODO DESERIALIZATION
    private static String requestBody = "{\n" +
            "  \"title\": \"Budilaq\",\n" +
            "  \"body\": \"Odilaq\",\n" +
            "  \"userId\": \"1\" \n}";


    @Before
    public void setup(){

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

    }

    @Test
    public void budilaq(){

        response=given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when().post("/posts")
                .then()
                .extract()
                .response();

        //validation ways
        assertThat(response.jsonPath().getString("title"),equalTo("Budilaq"));
        Assert.assertEquals(response.statusCode(),201);
        response.then().log().headers().header("Content-type", "application/json; charset=utf-8");

    }

    @Test
    public void odilaq(){

        //TODO SERIALIZATION
        Book book=new Book();
        book.setTitle("Budilaq");
        book.setBody("Odilaq");
        book.setUserId("1");

        // Gson is a class used to convert objects to json
        Gson gson=new Gson();
        String requestBody=gson.toJson(book);

        response=given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when().post("/posts")
                .then()
                .extract()
                .response();

        //validation ways
        assertThat(response.jsonPath().getString("title"),equalTo("Budilaq"));
        Assert.assertEquals(response.statusCode(),201);
        response.then().log().headers().header("Content-type", "application/json; charset=utf-8");

    }
}
