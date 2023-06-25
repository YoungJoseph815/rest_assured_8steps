package com.app.restassured;

import com.app.restassured.pojo.Book;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Step7_Parameters {

    //pathParam

    @BeforeClass
    public static void setUp(){
      RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
      RestAssured.basePath="{params}";
    }

    @Test
    public void getRequest(){
        given()
                .pathParam("params","posts")
                .when()
                .queryParam("userId","1")
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .prettyPrint();
    }

    @Test
    public void postRequest(){

        //TODO SERIALIZATION
        Book book=new Book();
        book.setTitle("Budilaq");

        Gson gson=new Gson();
        String requestBody=gson.toJson(book);

        Response response=given()
                .pathParam("params","users")
                .contentType(ContentType.JSON)
                .queryParam("userId","1")
                .body(requestBody)
                .when()
                .post()
                .then().extract().response();

        Logger.getRootLogger().info("Printing response body:");
        response.prettyPrint();

        assertThat(response.jsonPath().getString("title"),equalTo("Budilaq"));
        Assert.assertEquals(response.statusCode(),201);

    }

}
