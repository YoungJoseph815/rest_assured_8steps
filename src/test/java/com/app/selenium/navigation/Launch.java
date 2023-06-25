package com.app.selenium.navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launch {

    static Logger log=Logger.getLogger(Launch.class);
    static final String  url="https://google.com";


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        getLaunch(new ChromeDriver(),url);
        navigate(new ChromeDriver(),url);
        log.info("Test completed successfully");
    }

    static void getLaunch(WebDriver driver, String URL) throws InterruptedException {
        log.info("Launching using get()");
        driver.get(URL);
        log.info("Maxamizing screen");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        log.info("closing the browser");
        driver.close();

    }

    static void navigate(WebDriver driver, String URL) throws InterruptedException {
        driver.navigate().to(URL);
        Thread.sleep(1000);
        driver.navigate().to("https://bing.com");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.quit();

    }
}
