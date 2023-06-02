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

public class Step8_Authentication {


    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
        RestAssured.basePath="{params}";
    }

    @Test
    public void basicAuthentication(){

        //TODO SERIALIZATION
        Book book=new Book();
        book.setTitle("Budilaq");

        Gson gson=new Gson();
        String requestBody=gson.toJson(book);

        Response response=given().auth()
                .basic("username","password")
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

    @Test
    public void preemtiveAuthentication(){

        //TODO SERIALIZATION
        Book book=new Book();
        book.setTitle("Budilaq");

        Gson gson=new Gson();
        String requestBody=gson.toJson(book);

        Response response=given().auth()
                .preemptive()
                .basic("username","password")
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

    @Test
    public void bearerTokenAuthentication(){

        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyMDY0IiwiYXVkIjoidGVhY2hlciJ9.japWZkmQ3ExAJA6HxXEMSm92h5ZfYARx1Ci8sSiLgzM";

        //TODO SERIALIZATION
        Book book=new Book();
        book.setTitle("Budilaq");

        Gson gson=new Gson();
        String requestBody=gson.toJson(book);

        Response response=given()
                .header("Authorization","Bearer "+token)
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


    @Test
    public void auth2Authentication(){

        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyMDY0IiwiYXVkIjoidGVhY2hlciJ9.japWZkmQ3ExAJA6HxXEMSm92h5ZfYARx1Ci8sSiLgzM";

        //TODO SERIALIZATION
        Book book=new Book();
        book.setTitle("Budilaq");

        Gson gson=new Gson();
        String requestBody=gson.toJson(book);

        Response response=given().auth()
                .oauth2(token)
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
