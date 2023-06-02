package com.app.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Step5_PostRequestValidation {



    @Test
    public void getBook1() {

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification request = given();
        Response response=request
                          .header("Content-Type", "application/json")
                           .queryParam("id",'1')
                           .when().post("/users");

        //ways to print the response
        response.prettyPrint();
        System.out.println(response.jsonPath().getString("$"));
        System.out.println(response.asString());

        response.then().assertThat().statusCode(201);
        Assert.assertEquals("11",response.jsonPath().getString("id"));
        response.then().log().headers().header("Content-Type", "application/json; charset=utf-8");


    }

    @Test
    public void getBook2() {

                 given().baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .queryParam("id",'1')
                .when().post("/users")
                         .then()
                         .log()
                         .headers()
                         .header("Content-Type", "application/json; charset=utf-8")
                         .statusCode(201).log().body().toString().contains("id");

    }

}
