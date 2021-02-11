package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class US_Messages2 extends TestBase {

    //Logging in from TestBase
    @Test
    public void sendAMessage() {
        //1-Clicking on a message button
        Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click();

        BrowserUtils.sleep(2);
        //Finding frame and switching to it
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        Driver.getDriver().switchTo().frame(frame);

        //Finding message box and adding a message
        WebElement messageBox = Driver.getDriver().findElement(By.xpath("//body[@contenteditable='true']"));
        messageBox.sendKeys("We are the champions!");

        //Returning to default frame and finding send box
        Driver.getDriver().switchTo().defaultContent();

        Driver.getDriver().findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();

       // WebElement displayedMessage = Driver.getDriver().findElement(By.xpath("//div[.='We are the champions!']"));

        List<WebElement> allMessages = Driver.getDriver().findElements(By.xpath("//div[@class='feed-post-text-block-inner-inner']"));

        boolean failureMsg = true;

        for(WebElement eachMessage : allMessages){
            if(eachMessage.getText().equalsIgnoreCase("We are the champions!")) {
                System.out.println("Test Passed. Message is there");
                failureMsg = false;
            }
            if(failureMsg){
                System.out.println("Test failed!");
            }
        }



    }
}
