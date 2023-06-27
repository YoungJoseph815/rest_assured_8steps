package com.app.selenium.popups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticativePopUps {



    //Syntax: https://<username>:<password>@<domain>

    WebDriver driver;
    static final String domain = "the-internet.herokuapp.com/basic_auth";
    static final String username = "admin";
    static final String password = "admin";

    @Before
    public void launch() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @After
    public void flushout() {
        driver.quit();
    }

    @Test
    public void simpleAlert() throws InterruptedException {

        String url = "https://"+username+":"+password+"@"+domain;
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//div[@id='content']//h3//following-sibling::p")).getText().trim();
        Assert.assertEquals(text,"Congratulations! You must have the proper credentials.");
    }
    }
