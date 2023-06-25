package com.app.testng.assertions;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {

    @Test
    public void commonAssertions(){

        Assert.assertEquals("hello","HELLO".toLowerCase());
        Assert.assertNotEquals("hello","HELLO");

        Assert.assertTrue(1>0);
        Assert.assertFalse(1<0);

        Assert.assertNull(null);
        Assert.assertNotNull("hello");

        Student name1 = new Student();
        name1.name = "budilaq";
        Student name2 = name1;

        Student name3 = new Student();
        name3.name="budilaq";

        Assert.assertSame(name1,name2);
        Assert.assertNotSame(name1,name3);


        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(1>2);
        softAssert.assertEquals(1,1);
    }
}
