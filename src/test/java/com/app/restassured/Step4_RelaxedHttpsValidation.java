package com.app.restassured;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Step4_RelaxedHttpsValidation {


    @Before
    public void setup(){

        // we are going to trust connection with bad certificates
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://untrusted-root.badssl.com";

    }

    @Test
    public void badCert(){
        given().when().get().then().log().all().statusCode(200);
    }
}
