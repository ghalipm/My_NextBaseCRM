package com.nextBaseCRM.Tests;

import com.nextBaseCRM.Utils.BrowserUtils;
import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class US5 extends TestBase {


    /*
US#5. As a user, I should be able to vote for a poll
  1. Verify users can select an answer and vote for a poll.
      (if the poll is allowed multiple choice, then users select multiple as well )
      (screenshot is one sample poll Q/A)
  2. Verify users can vote again
  3. Verify poll owner can stop a poll

*/

    /*
    1. Verify users can select an answer and vote for a poll.
        (if the poll is allowed multiple choice, then users select multiple as well )
        (screenshot is one sample poll Q/A)
     */
    //Radio
    @Test
    public void testPollVotingRadio() {

        // refresh to see the poll just created under the message
        Driver.getDriver().navigate().refresh();

        //click "Message" tab
        String messageTab="(//span[.='Message'])[1]";
        Driver.getDriver().findElement(By.xpath(messageTab)).click();
        BrowserUtils.sleep(2);
        // if you see "Vote" button, click the first radio button and then click the vote button
        String voteRadio = "(//button[.='Vote'])[1]";

        // the first radio button
        String firstRadio = "(//tbody)[9]/tr[1]/td[1]"; // (//label[@for='vote_radio_525_1297'])[1]

        String voteAgainRadio = "(//*[@data-bx-vote-button='actVoting'])[4]";

        if(Driver.getDriver().findElement(By.xpath(voteRadio)).getText().equals("Vote")) {
            // click the first radio button
            Driver.getDriver().findElement(By.xpath(firstRadio)).click();
            // driver.switchTo().defaultContent();
            BrowserUtils.sleep(2);
            // click the vote button
            Driver.getDriver().switchTo().parentFrame();

           Driver.getDriver().findElement(By.xpath(voteRadio)).click();

        } else { // else click "Vote again" button first and then click the first radio button and then click vote button

            // clicking "Vote again" button
            Driver.getDriver().findElement(By.xpath(voteAgainRadio)).click();
            //click the first radio button and then click vote button
            // click the first radio button
            Driver.getDriver().switchTo().frame(2);
            Driver.getDriver().findElement(By.xpath(firstRadio)).click();
            //Driver.getDriver().switchTo().parentFrame();
            // click the vote button
            BrowserUtils.sleep(1);
            Driver.getDriver().findElement(By.xpath(voteRadio)).click();
        }
    }

    //Box multi choice
    @Test
    public void testPollVotingBox() {
        //use the testLogin method in NextBase_CRM_Library to login

        String voteButton="(//button[.='Vote'])[6]";
        String voteAgainButton="(//button[.='Vote again'])[4]";
        String firstBox="(//label[.='Mutator'])[2]";
        String thirdBox="(//span[@class='bx-vote-block-inp-substitute'])[16]";

        if(Driver.getDriver().findElement(By.xpath(voteButton)).getText().contains("Vote")) {
            Driver.getDriver().findElement(By.xpath(firstBox)).click();
            Driver.getDriver().findElement(By.xpath(thirdBox)).click();
            Driver.getDriver().findElement(By.xpath(voteButton)).click();
            BrowserUtils.sleep(1);
        }else{
            Driver.getDriver().findElement(By.xpath(voteAgainButton)).click();
            Driver.getDriver().findElement(By.xpath(firstBox)).click();
            Driver.getDriver().findElement(By.xpath(thirdBox)).click();
            Driver.getDriver().findElement(By.xpath(voteButton)).click();
            BrowserUtils.sleep(1);
        }


    }


    // US#5.3 Verify poll owner can stop a poll -->
    // first one has to create a poll , then one owns the poll,
    // then one can stop the poll.
    // A poll can only be created under "Poll",
    // but it shows up under "Message" only.(Not funny). Then one can stop it there.

    @Test
    public void testStoppingPoll() {

        // first, one has to create a poll, then one owns the poll, so
        // click to the "Poll" tab
        Driver.getDriver().findElement(By.xpath("(//span[.='Poll'])[2]")).click();
        BrowserUtils.sleep(1);
        // click on "Title"
        Driver.getDriver().findElement(By.xpath("//span[@title='Topic']")).click();
        BrowserUtils.sleep(1);


        //driver.findElement(By.xpath("//*[@id='POST_TITLE']")).clear();
        BrowserUtils.sleep(1);

        Driver.getDriver().findElement(By.xpath("//*[@id='POST_TITLE']")).click();

        // write post title : Sprint
        BrowserUtils.sleep(1);

        Driver.getDriver().findElement(By.xpath("//input[@id='POST_TITLE']")).sendKeys("Sprint2");
        BrowserUtils.sleep(1);

        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.sleep(1);

        Driver.getDriver().findElement(By.xpath("//*[@id='question_0']")).sendKeys("Choose Preferred Meeting Time");
        BrowserUtils.sleep(1);


        // write the first answer/option
        Driver.getDriver().findElement(By.xpath("//*[@placeholder='Answer  1']")).sendKeys("9am");
        Driver.getDriver().switchTo().defaultContent(); // without this, selenium does not know 9am story is finish
        BrowserUtils.sleep(1);

        Driver.getDriver().findElement(By.xpath("//*[@placeholder='Answer  2']")).sendKeys("10am");
        BrowserUtils.sleep(1);

        // so far so good
        Driver.getDriver().switchTo().defaultContent();

        // "Poll" content is saved - we have a poll now.
        Driver.getDriver().findElement(By.cssSelector("#blog-submit-button-save")).click();

        // A poll can only be created under "Poll",
        // but it shows up under "Message" only.(Not funny). Then one can stop it there.

        Driver.getDriver().navigate().refresh();
        // saved "Poll" may not be available under "Message", unless it is refreshed.

        // go to "Message" first
        Driver.getDriver().findElement(By.xpath("(//span[.='Message'])[2]")).click();
        //driver.navigate().refresh();

        // click "Stop" sign.
        Driver.getDriver().findElement(By.xpath("//button[.='Stop'] ")).click();


    }



}

/*
US#5. As a user, I should be able to vote for a poll
    1. Verify users can select an answer and vote for a poll.
        (if the poll is allowed multiple choice, then users select multiple as well )
        (screenshot is one sample poll Q/A)
    2. Verify users can vote agin
    3. Verify poll owner can stop a poll
 */