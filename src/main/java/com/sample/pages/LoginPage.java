package com.sample.pages;

import com.sample.base.BasePage;
import com.sample.dataProvider.ConfigFileReader;
import com.sample.managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginPage {
    BasePage basePage = new BasePage() ;
    static WebDriver driver;

    @FindBy(id = "email")
    private WebElement userName;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement login;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void loginIntoApp() {
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getURL());
    }
    public void inputUsernameAndPassword(String username, String pass) {
      //  basePage.inputvalue(userName, username);
     //   basePage.inputvalue(password,pass);
      //  basePage.click(loginbtn);
        userName.sendKeys(username);
        password.sendKeys(pass);
    }

    public void clickLoginBtn() {
       // basePage.click(login);
        login.click();
    }



}
