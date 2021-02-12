package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.LoginPage;
import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.ConfigurationReader;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

// checkout Robot class:
// https://www.guru99.com/using-robot-api-selenium.html#:~:text=Robot%20Class%20in%20Selenium%20is,control%20over%20mouse%20and%20keyboard.

public class US1 { // does not extend TestBase

    @Test
    public void US1_TC1_TC2_login_with_credentials_test() {
        LoginPage.loginWithCredentials("userHr", "password");
        BrowserUtils.sleep(2);
        Driver.closeDriver();// lacking this line, next test gets problem
    }

    @Test
    public void US1_TC3_userCanAccessForgotPassword() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath(LoginPage.forgotPasswordLink)).click();
        String expectedForgotPasswordInTitle = "Get Password";
        String actualForgotPasswordInTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedForgotPasswordInTitle,actualForgotPasswordInTitle,"Cannot reach forgot password link, FAILED");
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }


}
