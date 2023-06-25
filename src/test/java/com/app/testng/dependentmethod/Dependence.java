package com.app.testng.dependentmethod;

import org.testng.annotations.Test;

public class Dependence {

    @Test(dependsOnMethods = {"testCase2"})
    public void testCase1(){
        System.out.println("Test Case 1");
    }
    @Test
    public void testCase2(){
        System.out.println("Test Case 2");
    }


}
