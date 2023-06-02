package com.app.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class Step1_BaseURI {

    static Logger log = Logger.getLogger(Step1_BaseURI.class.getName());

    @Before
    public void setup(){
        RestAssured.baseURI="https://api.coincap.io";
        RestAssured.basePath="/v2/assets";
    }

    @Test
    public void findAssets(){

        RequestSpecification request=RestAssured.given();
        Response response=request.get();
      //  log.info("Printing response Way 1:");
      //  log.info(response.asString());
        log.info("Printing response Way 2:");
        response.prettyPrint();



    }


}
