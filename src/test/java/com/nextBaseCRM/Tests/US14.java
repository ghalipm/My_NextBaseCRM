package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Pages.LoginPage;
import com.nextBaseCRM.Pages.MainPage;
import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US14 extends TestBase{
    @Test
    public void testLogout(){
        // login is already there: due extending TestBase

        // User can logout and back to login page.
        WebElement dropDown= Driver.getDriver().findElement(By.xpath(MainPage.usernameXPath));
        BrowserUtils.sleep(1);
        dropDown.click();

        WebElement logoutLink=Driver.getDriver().findElement(By.xpath(LoginPage.logoutXPath));
        BrowserUtils.sleep(1);
        logoutLink.click();

        Driver.getDriver().findElement(By.xpath(LoginPage.loginBoxXpath)).clear();

        String expectedTitle="Authorization";
        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

}

 /*

US#1. As a user, I should be able to login to the app
    1. Verify users can login
    2. verify users can check ""Remember me on this computer"" option
    3. Verify users can access to ""FORGOT YOUR PASSWORD?"" link page

US#2. As a user, I should be able to send message.
    1. Verify users can send message by clicking ""MESSAGE"" tab
    2. Verify users can cancel message.
    3. Verify users can attach link by clicking on the link icon."

US#3. As a user, I should be able to search people, document and more from search box"
    1. Verify users can search a valid info from search box. (employee, doc, post, etc)
    2. Verify users get menu item and suggested modules when they type in the box.


US#4. As a user, I should be able to create a poll
    1. Verify users can write a poll message title with question & answer.
    2. Verify users can check ""allow multiple Choice""
    3. Verify users can add questions
    4. Verify users can cancel poll"

US#5. As a user, I should be able to vote for a poll
    1. Verify users can select an answer and vote for a poll.
        (if the poll is allowed multiple choice, then users select multiple as well )
        (screenshot is one sample poll Q/A)
    2. Verify users can vote again
    3. Verify poll owner can stop a poll

US#6. As a user, I should be able to log work hours with time reporting"
	1. Verify users can clock in
    2. Verify users can clock out.
    3. Verify users can edit Today's task under daily plan.
    4. Verify users can add events.
    5. Verify users can edit work day starting and ending time.
    (hour change buttons are web table, great practice)"

US#7. As a user, I should be able to do see posts from homepage. "
	1. Verify users can like a post (message, task, poll, event , etc).
    2. Verify users can follow posts.
    3. Verify users can see how many people viewed a post.
    4. Verify users can save a post as favorite.
    5. Verify users can send or cancel a comment to any post.

US#8. As a user, I should be able to see all the tasks under Task module"
    1. Verify only hr and marketing team members can access to Task module.
    2. Verify users can see all the task on task page.
    3. Verify users can select all the task with a check box on the 1st row.
    4. Verify users can access to any module by one click.

US#9. As a user, I should be able to send an event.
    1. Verify users can send events by clicking ""EVENT"" tab with at least an event name.
    2. Verify users can cancel events.
    3. Verify users can check timers
    4. Verify users can choose all day for the event time"

US#10. As a user, I should be able to assign tasks by clicking on Task tab."
    1. Users can check  ""High Priority""
    2. Users can click on ""Checklist"" to create checklists items
    3. Users can add Deadline, Time Planning by using date pickers.(check box practice)"

US#11. As a user, I should be able to access to time and reports module"
    1. Verify only hr and marketing team can access to time and report module.
    2. Verify users can filter absence chart by day / week / month
    3. Verify users can check statistics under work time
    4. Verify users can check Show start and end times under work time "

US#12. As a user, I should be able to use ""Filter and search"" functionality on Active Stream."
	1. Verify users search by type-in keyword to search previous posts
    2. Verify users can search by editing Date, Type, Author, To and more default dropdowns.
    3. Users should be able to Filter by work, favorites, my activity, announcement and workflow. "

US#13. As a user, I should be able to access to main modules of the app. "
    "1. Verify only authorized users can access to main modules. (authorized = hr & marketing)

US#14. As a user, I should be able to logout from the app"
    "1. Verify users can logout and back to login page. "

 */
