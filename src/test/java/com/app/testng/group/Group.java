package com.app.testng.group;

import org.testng.annotations.Test;

public class Group {

    @Test(groups = { "smokeTest", "Regression Test" })
    public void testcase1(){
        System.out.println("Logged in successfully");
    }


    @Test(groups = { "Regression Test" })
    public void testcase2(){
        System.out.println("Logged in successfully");
    }


    @Test(groups = { "smokeTest", "Regression Test" })
    public void testcase3(){
        System.out.println("Logged in successfully");
    }
}
