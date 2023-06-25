package com.app.testng.disable;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Skip {

    @Test
    public void aSkipTest(){

      throw new SkipException("Skipping - This is not ready for testing ");
    }

    @Test
    public void nonSkipTest(){
        System.out.println("No need to skip this test");
    }


}
