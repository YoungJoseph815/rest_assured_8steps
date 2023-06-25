package com.app.testng.exception;

import org.testng.annotations.Test;

public class TestNGException {

    @Test(expectedExceptions = ArithmeticException.class)
    public void testException() {

        System.out.println("Please dont divide by zero");
        int i = 1 / 0;
        System.out.println(i);
    }
}
