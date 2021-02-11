package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.LoginPage;
import com.nextBaseCRM.Utils.ConfigurationReader;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1_TC3 {

    @Test
    public void US1_TC3_userCanAccessForgotPassword() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath(LoginPage.forgotPasswordLink)).click();
        String expectedForgotPasswordTitle = "Get Password";
        String actualForgotPasswordTitle = Driver.getDriver().getTitle();
        System.out.println("actualForgotPasswordTitle = " + actualForgotPasswordTitle);
        Assert.assertEquals(expectedForgotPasswordTitle,actualForgotPasswordTitle,"Cannot reach forgot password link, FAILED");


    }

}
