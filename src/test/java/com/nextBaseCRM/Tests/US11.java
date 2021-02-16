package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.MainPage;
import com.nextBaseCRM.Pages.US11Page;
import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US11 extends TestBase{

    //1. Verify only hr and marketing team can access to time and report module.
    // this is Done in US#13

    // 2. Verify users can filter absence chart by day / week / month

    @Test
    public void absence_chart_filter_test() {
        Driver.getDriver().findElement(By.xpath(MainPage.timeAndReportsTabXpath)).click();
        BrowserUtils.sleep(1);

        WebElement absenceDay=Driver.getDriver().findElement(By.cssSelector(US11Page.absenceDayCssSel));
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", absenceDay);
        absenceDay.isDisplayed();
        BrowserUtils.sleep(1);

        WebElement absenceWeek=Driver.getDriver().findElement(By.cssSelector(US11Page.absenceWeekCssSel));
        JavascriptExecutor executorWeek = (JavascriptExecutor) Driver.getDriver();
        executorWeek.executeScript("arguments[0].click();", absenceWeek);
        absenceWeek.isDisplayed();
        BrowserUtils.sleep(1);

        WebElement absenceMonth=Driver.getDriver().findElement(By.cssSelector(US11Page.absenceMonthCssSel));
        JavascriptExecutor executorMonth = (JavascriptExecutor) Driver.getDriver();
        executorMonth.executeScript("arguments[0].click();", absenceMonth);
        absenceMonth.isDisplayed();
        BrowserUtils.sleep(1);


    }

    //3. Verify users can check statistics under work time


    //4. Verify users can check Show start and end times under work time "

    // for week: td.bx-calendar-week-day
    //for day: td.bx-calendar-day-hour-long
    //for month: td.bx-calendar-month-day


}

/*
US#11. As a user, I should be able to access to time and reports module"

    2. Verify users can filter absence chart by day / week / month
    3. Verify users can check statistics under work time
    4. Verify users can check Show start and end times under work time "
 */