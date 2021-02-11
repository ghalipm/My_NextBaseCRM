package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.LoginPage;
import com.nextBaseCRM.Utils.ConfigurationReader;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1_TC2 {

    @Test
    public void US1_TC2_userCanCheckRememberMe() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        WebElement remember= Driver.getDriver().findElement(By.xpath(LoginPage.rememberMeCheckBoxXpath));
        remember.click();
        Assert.assertTrue(remember.isSelected());

    }
}
