package com.app.restassured;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.notNullValue;

public class Step3_AdvancedGetValidation {

    static Logger log = Logger.getLogger(Step1_BaseURI.class.getName());

    //Rest Assured log()
    //Rest Assured Validation body/status code/header
    //gherkin style steps like given()/when()/then()

    @Before
    public void setup() {

        log.info("Test Started: ");
        RestAssured.baseURI = "https://api.coincap.io/";

    }

    @Test
    public void getSpecificValues() {
        //validating response body
       given().when().get("/v2/assets").then().assertThat().body("timestamp",notNullValue()).log().body();
        given().when().get("/v2/assets").then().assertThat().body("data.id",hasItems("bitcoin","ethereum")).log().body();
        //validating headers
        given().when().get("/v2/assets").then().log().headers().header("Content-Type","application/json; charset=utf-8");

        //validating status code
        given().when().get("/v2/assets").then().statusCode(200);
        given().when().get("/v2/assets").then().log().ifStatusCodeIsEqualTo(200).body("data.id",hasItems("bitcoin","ethereum"));

    }
}
