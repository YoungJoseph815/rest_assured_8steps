package com.app.selenium.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class EightLocators {

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
    public void amazonHomePage() throws InterruptedException {
        driver.get("https://"+url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        String pageTitle=driver.getTitle();

        WebElement id= driver.findElement(By.id("nav-logo"));
        WebElement xpath=driver.findElement(By.xpath("//div[@id='nav-logo']"));
        WebElement cssSelector= driver.findElement(By.cssSelector("div[id='nav-logo']"));
        WebElement className=driver.findElement(By.className("nav-line-2 nav-progressive-content"));
        WebElement linkText= driver.findElement(By.linkText("Select your address"));
        WebElement partialLinkText=driver.findElement(By.partialLinkText("your address"));
        WebElement name=driver.findElement(By.name("site-search"));
        List<WebElement> tagName=driver.findElements(By.tagName("h1"));

        Assert.assertTrue("Failed: page title mismatch",pageTitle.contains(url));

        driver.quit();

    }

    @Test
    public void advancedXpath(){

        driver.get("https://"+url);
        driver.manage().window().maximize();

//        <div id="nav-logo">
//    <a href="/ref=nav_logo" id="nav-logo-sprites" class="nav-logo-link nav-progressive-attribute" aria-label="Amazon">
//      <span class="nav-sprite nav-logo-base"></span>
//      <span id="logo-ext" class="nav-sprite nav-logo-ext nav-progressive-content"></span>
//      <span class="nav-logo-locale">.us</span>
//    </a>
//  </div>

        WebElement sibling=driver.findElement(By.xpath("//div[@id='nav-logo']//a[@id='nav-logo-sprites']//following-sibling::span[@id='logo-ext']"));
        WebElement ancestor= driver.findElement(By.xpath("//span[@id='logo-ext']//ancestor::div[@id='nav-logo']"));
        WebElement or= driver.findElement(By.xpath("//a[@class='nav-logo' or @id='nav-logo-sprites']"));
        WebElement and=driver.findElement(By.xpath("//*[@id='nav-logo-sprites'  and @aria-label='Amazon' ]"));
        WebElement startWith= driver.findElement(By.xpath("//div[starts-with(@id,'nav-l')]"));
        WebElement contains= driver.findElement(By.xpath("//div[contains(@id,'-logo')]"));

        Assert.assertTrue(contains.isDisplayed());

    }


}
