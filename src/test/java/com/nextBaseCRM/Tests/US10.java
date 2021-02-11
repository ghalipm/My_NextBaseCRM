package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.MainPage;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US10 extends TestBase{

    @Test
    public void TC1_CheckBoxSelected() throws InterruptedException {
        //Test case 1: Verify user can check"high priority" check box

        // click Task sub-module
        Driver.getDriver().findElement(By.xpath(MainPage.TaskTabXpath)).click();
        Thread.sleep(2000);

        // click on"High Priority" checkbox on right hand corner
        WebElement HighPriorityCheckBox =  Driver.getDriver().findElement(By.id("tasks-task-priority-cb"));
        HighPriorityCheckBox.click();
        Thread.sleep(2000);

        // verify "high Priority" check box is selectable
        Assert.assertTrue(HighPriorityCheckBox.isSelected());

    }

    @Test
    public void TC2_CheckList() throws InterruptedException {
        // Test case 2:user can click on "checklist" icon to create checklist items

        //click on task tab
        Driver.getDriver().findElement(By.xpath(MainPage.TaskTabXpath)).click();
        Thread.sleep(2000);

        // click on "checklist"
        Driver.getDriver().findElement(By.xpath("//span[@class='tasks-task-mpf-link']")).click();
        Thread.sleep(4000);


        //send message to checklist box
        WebElement thingsToDo = Driver.getDriver().findElement(By.xpath("//input[@class='js-id-checklist-is-form-title task-checklist-field-add']"));
        thingsToDo.sendKeys("finish project" + Keys.ENTER);
        Thread.sleep(2000);

        //assert if checklist message is displayed in the box
//       WebElement checkListMessage = Driver.getDriver().findElement(By.xpath("//div[@class='task-checklist-title']"));
//    Assert.assertTrue(checkListMessage.isDisplayed());

        //verify the customized message is been created/displayed
        WebElement message = Driver.getDriver().findElement(By.xpath("//span[@class='js-id-checklist-is-i-title ']"));
        Assert.assertTrue(message.isDisplayed());
    }

        @Test
        public void TC3_datePickers() throws InterruptedException {
            // Test case 3:user can add deadline, time planning by using date pickers

            // click on task tab
            Driver.getDriver().findElement(By.xpath(MainPage.TaskTabXpath)).click();
            Thread.sleep(2000);

            //CLick on deadline box and choose any date, then click on select button
        WebElement deadlineBox = Driver.getDriver().findElement(By.xpath("(//input[@class='task-options-inp'])[1]"));
        deadlineBox.click();







        }







    }






//Test case 1: Verify user can check"high priority" check box
// 1. log in as user
// 2.click Task sub-module
//3. click on"High Priority" checkbox on right hand corner
//4. verify "high Priority" check box is selectable

// Test case 2:user can click on "checklist" icon to create checklist items
//1. click on "checklist"
// verify checklish message id diplayed
//2.send message to checklist box
//3.verify the checklist message is been created/displayed

// Test case 3:user can add deadline, time planning by using date pickers.(check box)
//1.Click on Task Tab

//CLick on deadline box and choose any date, then click on select button
//click on time planning to choose the date, then click on select button
//click on start task on box" to input start date info then select
//click on finish box to choose date then choose



