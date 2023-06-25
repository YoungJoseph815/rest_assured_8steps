package com.app.testng.parallel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parallel {

    @Test
    public void getFirefox(){

        WebDriverManager.edgedriver().setup();
        System.out.println("GetFirefox Method is running on Thread : " + Thread.currentThread().getId());
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.softwaretestingmaterial.com");
        driver.close();
    }

    @Test
    public void getChorme(){

        WebDriverManager.chromedriver().setup();
        System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.softwaretestingmaterial.com");
        driver.close();
    }


}
