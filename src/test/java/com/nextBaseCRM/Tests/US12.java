package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.US12Page;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class US12 extends TestBase{
    // login is done automatically - due to Before method in TestBase.

    /*
    US#12. As a user, I should be able to use ""Filter and search"" functionality on Active Stream."
        1. Verify users search by type-in keyword to search previous posts
        2. Verify users can search by editing Date, Type, Author, To and more default dropdowns.
        3. Users should be able to Filter by work, favorites, my activity, announcement and workflow. "
     */

    @Test
    public void testUserSearchByKeyword() throws InterruptedException {

        //As a user, I should be able to use ""Filter and search"" functionality on Active Stream."
        Driver.getDriver().findElement(By.xpath(US12Page.filterSearchTabXpath)).click();
        Thread.sleep(3000);

        // create an array of search keywords, then use a for each loop
        // thanks to the loop idea, TC1, TC2, TC3 can be made into one TC.

        // Since we do not have a list of previously posted anything, it is better to use "Message" module send out messages
        // and use "Poll" module to create poll etc using certain words, then keep these words in an array and search them !
        String[] keyWordArray = new String[]{"Employee", "hr8", "To", "Today", "Yesterday","February 4", "favorite","Announcement","planning", "Sprint", "hotfix","Meeting"};

        for (int i = 0; i < keyWordArray.length; i++) {

            //1. Verify users search by type-in keyword to search previous posts
            Driver.getDriver().findElement(By.xpath(US12Page.searchKeyWordXpath)).sendKeys(keyWordArray[i]);

            ArrayList<WebElement> keyWordWEList ;
            String xPath = "//*[contains(text(),'" + keyWordArray[i] + "')]";
            keyWordWEList = (ArrayList<WebElement>) Driver.getDriver().findElements(By.xpath(xPath));
            Assert.assertFalse(keyWordWEList.isEmpty(), "failed at keyword: "+ keyWordArray[i] );

            System.out.println("keyWordList.size() = " + keyWordWEList.size());

            for (WebElement webElement : keyWordWEList) {
                System.out.println("Keyword: "+webElement.getText());
            }

            Driver.getDriver().navigate().refresh(); // to refresh the "Filter and search" area.

            Driver.getDriver().findElements(By.xpath(xPath));


        }


    }

}
