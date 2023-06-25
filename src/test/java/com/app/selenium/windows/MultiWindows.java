package com.app.selenium.windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class MultiWindows {


    WebDriver driver;
    static final String url="https://demoqa.com/browser-windows";

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
    public void singleNewWindow() {

        driver.get(url);
        driver.manage().window().maximize();
        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();

        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String eachWindow = iterator.next();
            System.out.println("Each window handle: "+eachWindow);
            if (!mainWindowHandle.equalsIgnoreCase(eachWindow)) {
                driver.switchTo().window(eachWindow);
                WebElement newWindowHeaderText=driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + newWindowHeaderText.getText());
                Assert.assertEquals("This is a sample page",newWindowHeaderText.getText());
            }
        }
    }

    @Test
    public void multipleNewWindow() {

        driver.get(url);
        driver.manage().window().maximize();
        WebElement window1 = driver.findElement(By.id("windowButton"));
        WebElement window2=driver.findElement(By.id("messageWindowButton"));

        window1.click();
        window2.click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);


        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Child window handle is" + allWindowHandles);
        Iterator<String> windows = allWindowHandles.iterator();

        while (windows.hasNext()) {
            String eachWindow = windows.next();
            System.out.println("Each Child windows: "+eachWindow);
            if (!MainWindow.equalsIgnoreCase(eachWindow)) {
                driver.switchTo().window(eachWindow);
              //  Assert.assertTrue(driver.getTitle().contains("Personal"));
                driver.close();
                System.out.println("Child window closed");
            }
        }
        driver.switchTo().window(MainWindow);
       // Assert.assertEquals("DEMOQA",driver.getTitle());
    }




    }
