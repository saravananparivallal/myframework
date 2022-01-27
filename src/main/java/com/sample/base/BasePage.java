package com.sample.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;
    public void inputvalue(WebElement element, String value){
    if(element.isEnabled()){
        element.clear();
        element.sendKeys(value);
    }
}
public void click(WebElement element){
    if(element.isEnabled()){
        element.click();
    }
}
public void implicitWait(int seconds){
    driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
}

}
