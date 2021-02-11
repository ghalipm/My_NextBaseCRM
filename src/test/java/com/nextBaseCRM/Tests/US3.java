package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.MainPage;
import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US3 extends TestBase{

    @Test
    public void US3_TC1_conduct_a_search() {

        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("jack ");
        BrowserUtils.sleep(3);




        List<WebElement> employees = Driver.getDriver().findElements(By.xpath(MainPage.employeesXpath));
        List<WebElement> conversations=Driver.getDriver().findElements(By.xpath(MainPage.conversationsXpath));
        List<WebElement> other = Driver.getDriver().findElements(By.xpath(MainPage.otherXpath));
        List<WebElement> searchMenuItems = Driver.getDriver().findElements(By.xpath(MainPage.searchMenuItemXpath));
        Assert.assertFalse(employees.isEmpty());
        Assert.assertFalse(conversations.isEmpty());
        Assert.assertFalse(other.isEmpty());
        Assert.assertFalse(searchMenuItems.isEmpty());
    }
}
