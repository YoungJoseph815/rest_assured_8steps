package com.app.selenium.selection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selection {

    WebDriver driver;
    static final String url="https://demo.guru99.com/test/newtours/register.php";

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
    public void everythingAboutSelection(){

        driver.get(url);
        WebElement countryDropDown= driver.findElement(By.name("country"));

        Select selectCountry = new Select(countryDropDown);

        selectCountry.selectByVisibleText("ALBANIA");
        selectCountry.deselectByVisibleText("ALBANIA");

        selectCountry.selectByValue("234");
        selectCountry.deselectByValue("234");

        selectCountry.selectByIndex(0);
        selectCountry.deselectByIndex(0);

        selectCountry.getFirstSelectedOption();
        selectCountry.deselectAll();

        if(selectCountry.isMultiple())
        {
            System.out.println("Select tag allows multiple selection");
        }
        else
        {
            System.out.println("Select does not allow multiple selections");
        }




    }
}
