package com.app.selenium.iframes;

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

public class HandleiFrame {


    WebDriver driver;
    static final String url="https://demoqa.com/frames";

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
    public void switchingiFrames() {

        driver.get(url);
        driver.manage().window().maximize();

        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());

       // driver.switchTo().frame(0);
      // driver.switchTo().frame("iframe");
       // driver.switchTo().frame("frame1");
        driver.switchTo().frame(driver.findElement(By.id("frame1")));

        WebElement sampleHeading=driver.findElement(By.id("sampleHeading"));
        System.out.println("Text inside the iFrame: "+sampleHeading.getText());
        Assert.assertEquals("This is a sample page",sampleHeading.getText());

        //Outside iframe main page
        driver.switchTo().defaultContent();
        WebElement text=driver.findElement(By.xpath("//div[contains(text(),'Sample Iframe page')]"));
        System.out.println("Text outside the iFrame: "+text.getText());


    }
}
