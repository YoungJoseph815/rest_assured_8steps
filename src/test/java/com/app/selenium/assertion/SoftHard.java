package com.app.selenium.assertion;

import com.app.selenium.navigation.Launch;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class SoftHard {

    static Logger log=Logger.getLogger(SoftHard.class);

    WebDriver driver;
    static final String url="Amazon.com";

    @Before
    public void launch(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }

    @After
    public void flushout(){
        driver.quit();
    }

    @Test
    public void hardAssertion(){

        driver.get("https://"+url);
        driver.manage().window().maximize();

        WebElement sibling=driver.findElement(By.xpath("//div[@id='nav-logo']//a[@id='nav-logo-sprites']//following-sibling::span[@id='logo-ext']"));
        WebElement ancestor= driver.findElement(By.xpath("//span[@id='logo-ext']//ancestor::div[@id='nav-logo']"));


        log.info("Hard assertion 1");
        Assert.assertTrue(sibling.isDisplayed());
        log.info("Hard assertion 2");
        Assert.assertTrue(ancestor.isDisplayed());

    }

    @Test
    public void softAssertion(){

        driver.get("https://"+url);
        driver.manage().window().maximize();

        WebElement sibling=driver.findElement(By.xpath("//div[@id='nav-logo']//a[@id='nav-logo-sprites']//following-sibling::span[@id='logo-ext']"));
        WebElement ancestor= driver.findElement(By.xpath("//span[@id='logo-ext']//ancestor::div[@id='nav-logo']"));

        SoftAssert softAssert=new SoftAssert();

        log.info("Soft assertion 1");
        softAssert.assertTrue(sibling.isDisplayed());
        log.info("Soft assertion 2");
        softAssert.assertTrue(ancestor.isDisplayed());

    }

}
