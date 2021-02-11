package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US4_Poll extends TestBase {

    // logging in

    @Test
    public void creatingPoll(){
        //1- From Home page click on Poll
        Driver.getDriver().findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']")).click();

        BrowserUtils.sleep(2);
        //Finding frame and switching to it
        WebElement frame = Driver.getDriver().findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        Driver.getDriver().switchTo().frame(frame);

        //Finding message box and adding a message title for a poll
        WebElement messageBox = Driver.getDriver().findElement(By.xpath("//body[@contenteditable='true']"));

        //We are adding a Title Message
        messageBox.clear();
        BrowserUtils.sleep(2);
        messageBox.sendKeys("Tell me about your favorite color?");

        //Returning to default frame and finding send box
        Driver.getDriver().switchTo().defaultContent();

        //Asking Poll Question
        BrowserUtils.sleep(2);
        WebElement questionBox = Driver.getDriver().findElement(By.xpath("//input[@id='question_0']"));
        questionBox.clear();
        questionBox.sendKeys("What is your favorite color?");

        WebElement firstAnswer = Driver.getDriver().findElement(By.xpath("(//input[@class='vote-block-inp adda'])[1]"));
        WebElement secondAnswer = Driver.getDriver().findElement(By.xpath("(//input[@class='vote-block-inp adda'])[2]"));

        //Adding first answer
        BrowserUtils.sleep(2);
        firstAnswer.clear();
        firstAnswer.sendKeys("Blue");

        //Adding second answer
        BrowserUtils.sleep(2);
        secondAnswer.clear();
        secondAnswer.sendKeys("Orange");

        //Sending a Poll question
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();



    }


}
