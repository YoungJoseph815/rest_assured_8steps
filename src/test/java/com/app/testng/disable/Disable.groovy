package com.app.testng.disable

import org.testng.annotations.Test

class Disable {

    @Test(enabled = false)
    public void testcase1(){
        System.out.println("test case 1");
    }

    @Test
    public void testcase2(){
        System.out.println("test case 2");
    }


}
