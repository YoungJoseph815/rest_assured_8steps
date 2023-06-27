package com.app.selenium.popups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUps {

    //Selenium can NOT handle windows based popup, it only handles web based pop up!


    WebDriver driver;
    static final String url = "https://demoqa.com/alerts";

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
    public void simpleAlert() {

        driver.get(url);
        driver.manage().window().maximize();

        driver.findElement(By.id("alertButton")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }

    @Test
    public void confirmationAlert() {

        driver.get(url);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("confirmButton"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        confirmationAlert.accept();
      //  confirmationAlert.dismiss();
    }

    @Test
    public void unexpectedAlert() {

        driver.get(url);
        driver.manage().window().maximize();

        try {

            driver.findElement(By.id("timerAlertButton")).click();
            WebDriverWait wait = new WebDriverWait(driver,10);

            wait.until(ExpectedConditions.alertIsPresent());

            Alert simpleAlert = driver.switchTo().alert();
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");

        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
    }






    @Test
    public void promptAlertWithText() {

        driver.get(url);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("promtButton"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

        Alert promptAlert  = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);

        promptAlert.sendKeys("Test User");
        promptAlert.accept();
        System.out.println("Alert text is " + alertText);

    }
}
