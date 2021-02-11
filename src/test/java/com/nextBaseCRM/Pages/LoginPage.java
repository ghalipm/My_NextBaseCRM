package com.nextBaseCRM.Pages;

import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.ConfigurationReader;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    public static final String loginBoxXpath = "//input[@placeholder='Login']";
    public static  final String passwordBoxXpath = "//input[@placeholder='Password']";
    public static final String rememberMeCheckBoxXpath = "//input[@id='USER_REMEMBER']";
    public static final String loginButtonXpath = "//input[@value='Log In']";
    public static final String forgotPasswordLink="//a[.='Forgot your password?']";
    public static final String logoutXPath="//span[.='Log out']";


    public static void login(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath(loginBoxXpath)).sendKeys(ConfigurationReader.getProperty("userHelpDesk"));
        Driver.getDriver().findElement(By.xpath(passwordBoxXpath)).sendKeys(ConfigurationReader.getProperty("password"));
        Driver.getDriver().findElement(By.xpath(rememberMeCheckBoxXpath)).click();
        Driver.getDriver().findElement(By.xpath(loginButtonXpath)).click();
    }


    public static void loginWithCredentials(String userName, String passWord){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath(loginBoxXpath)).sendKeys(ConfigurationReader.getProperty(userName));
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath(passwordBoxXpath)).sendKeys(ConfigurationReader.getProperty(passWord));
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath(rememberMeCheckBoxXpath)).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath(loginButtonXpath)).click();
        // check if Url title contains "Portal".
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Portal"));

    }



}
