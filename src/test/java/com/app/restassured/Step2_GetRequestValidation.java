package com.app.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Step2_GetRequestValidation {

    // hamcrest validation body/status code/header


    static Logger log = Logger.getLogger(Step1_BaseURI.class.getName());
    RequestSpecification request;
    Response response;

    @Before
    public void setup(){

        log.info("Test Started: ");
        RestAssured.baseURI="https://api.coincap.io/";
        RestAssured.basePath="/v2/assets";


    }

    @Test
    public void validateAssetID(){

        request=RestAssured.given();
        response=request.get();

        log.info("Test completed! ");

        assertThat("Failed: response body mismatch!",response.asString().contains("bitcoin"));
        assertThat("Failed: status code mismatch!",response.statusCode(), equalTo(200));
        assertThat("Failed: header mismatch!",response.header("Content-Type"), is("application/json; charset=utf-8"));

    }



}
