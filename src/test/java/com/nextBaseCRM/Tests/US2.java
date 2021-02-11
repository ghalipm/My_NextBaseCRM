package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.MainPage;
import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US2 extends TestBase {

    @Test
    public void US2_TC1_sendMessage()  {


        Driver.getDriver().findElement(By.xpath(MainPage.sendMessageBoxXpath)).click();
        // locate the iframe first and save a webElement
        // place the webElement inside the switch() expression
        BrowserUtils.sleep(3);
        Driver.getDriver().switchTo().frame(MainPage.messageFrameWebElement);
        // write the message
        String message = "KAAA1234";
        Driver.getDriver().findElement(By.xpath(MainPage.messageBodyXpath)).sendKeys(message);

        String actualMessage = Driver.getDriver().findElement(By.xpath(MainPage.writtenMessageLocation)).getText();
        System.out.println(actualMessage);

        Driver.getDriver().switchTo().parentFrame();// getting out iframe
        Driver.getDriver().findElement(By.xpath(MainPage.sendButton)).click();

        Assert.assertEquals(actualMessage, message);
        Driver.getDriver().switchTo().parentFrame();// getting out iframe


        /*
        Another approach

        Driver.getDriver().findElement(By.xpath(MainPage.sendMessageBoxXpath)).click();
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        Driver.getDriver().switchTo().frame(frame);
       Driver.getDriver().findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("Hello8");
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().findElement(By.xpath(MainPage.sendButton)).click();
        // verify

        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='feed-post-text-block-inner-inner']"));
        boolean testFlag = true;
        for (WebElement webElement : list) {
            if (webElement.getText().equals("Hello8")) {
                System.out.println("Text displayed, PASS");
                testFlag = false;
                //break;
            }
        }

        if (testFlag) {
            System.out.println("Test Failed!");
        }
         */
    }

    @Test
    public void US2_TC2_userCancelMessage() {

        Driver.getDriver().findElement(By.xpath(MainPage.sendMessageBoxXpath)).click();
        // locate the iframe first and save a webElement
        // place the webElement inside the switch() expression
        BrowserUtils.sleep(3);
        Driver.getDriver().switchTo().frame(MainPage.messageFrameWebElement);


        // write the message
        String message = "K123ABC";
        Driver.getDriver().findElement(By.xpath(MainPage.messageBodyXpath)).sendKeys(message);


        Driver.getDriver().switchTo().defaultContent();

        Driver.getDriver().findElement(By.xpath(MainPage.cancelButtonXpath)).click();
        BrowserUtils.sleep(2);
        Driver.getDriver().switchTo().frame(MainPage.messageFrameWebElement);
        String actualMessage = Driver.getDriver().findElement(By.xpath(MainPage.writtenMessageLocation)).getText();
       // System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.isEmpty());

    }

    @Test
    public void US2_TC3_attachLink() {
        Driver.getDriver().findElement(By.xpath(MainPage.sendMessageBoxXpath)).click();
        Driver.getDriver().findElement(By.xpath(MainPage.linkXpath)).click();
        String url = "Google";
        Driver.getDriver().findElement(By.xpath(MainPage.linkTextXpath)).sendKeys(url);
        Driver.getDriver().findElement(By.xpath(MainPage.linkUrlXpath)).sendKeys("https://www.google.com", Keys.ENTER);

        Driver.getDriver().switchTo().frame(MainPage.messageFrameWebElement);
        String actualLinkText = Driver.getDriver().findElement(By.xpath(MainPage.writtenMessageLocation)).getText();
        System.out.println(actualLinkText);
         Assert.assertEquals(url,actualLinkText);


    }
}
