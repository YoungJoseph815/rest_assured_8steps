package com.app.testng.priority;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority=1)
    public void testCase1() {
        System.out.println("Test Case 1");
    }
    @Test(priority=0)
    public void testCase2() {
        System.out.println("Test Case 2");
    }
}
