package com.app.testng.invocationCount;

import org.testng.annotations.Test;

public class MultipleRun {

    @Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
    public void testCase1(){

        System.out.println("Say my name!");
    }
}
