package com.app.testng.annotations;

import org.testng.annotations.*;

public class Annotations {

    @BeforeSuite
    public void beforesuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void beforetest(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("BeforeMethod");
    }


    @Test
    public void test(){
        System.out.println("test");
    }


    @AfterMethod
    public void aftermethod(){
        System.out.println("AfterMethod");
    }

    @AfterClass
    public void afterclass(){
        System.out.println("AfterClass");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("AfterSuite");
    }

    //OutPut

//    BeforeSuite
//    BeforeTest
//    BeforeClass
//    BeforeMethod
//    test
//    AfterMethod
//    AfterClass
//    AfterTest
//    AfterSuite
}
