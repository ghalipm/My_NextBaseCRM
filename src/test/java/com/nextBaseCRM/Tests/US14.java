package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.LoginPage;
import com.nextBaseCRM.Pages.MainPage;
import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US14 extends TestBase{
    @Test
    public void testLogout(){
        // login is already there: due extending TestBase

        // User can logout and back to login page.
        WebElement dropDown= Driver.getDriver().findElement(By.xpath(MainPage.usernameXPath));
        BrowserUtils.sleep(1);
        dropDown.click();

        WebElement logoutLink=Driver.getDriver().findElement(By.xpath(LoginPage.logoutXPath));
        BrowserUtils.sleep(1);
        logoutLink.click();

        Driver.getDriver().findElement(By.xpath(LoginPage.loginBoxXpath)).clear();

        String expectedTitle="Authorization";
        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

}
