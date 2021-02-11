package com.nextBaseCRM.Pages;

import com.nextBaseCRM.Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {

    public static final String sendMessageBoxXpath="//span[@id='feed-add-post-form-tab-message']";//outside the frame
    public static final String messageIframeXpath = "//*[@id='bx-html-editor-iframe-cnt-idPostFormLHE_blogPostForm']/iframe"; //located iframe as a web element
    public static final WebElement messageFrameWebElement = Driver.getDriver().findElement(By.xpath(messageIframeXpath));
    public static final String messageBodyXpath="//body[@contenteditable='true']"; // inside the frame, where we write actual message
    public static final String writtenMessageLocation ="/html/body";//needed for assertion, where written message is stored
    public static final String sendButton ="//*[@id='blog-submit-button-save']";//outside the frame
    public static final String cancelButtonXpath="//button[@id='blog-submit-button-cancel']";
    public static final String linkXpath="//span[@title='Link']";
    public static final String linkTextXpath= "//input[@id='linkidPostFormLHE_blogPostForm-text']";
    public static final String linkUrlXpath= "//input[@id='linkidPostFormLHE_blogPostForm-href']";

    public static final String TaskTabXpath = "//span[@id='feed-add-post-form-tab-tasks']";
    public static final String usernameXPath="//span[@id='user-name']";

    //Search elements

    public static final String employeesXpath= "(//div[.='Employees'])/..//a/span/span";
    public static final String conversationsXpath= "(//div[.='Conversations'])/..//a/span/span";
    public static final String otherXpath= "(//div[.='Other'])/..//a/span/span";
    public static final String searchMenuItemXpath= "(//div[.='Search'])/..//a/span/span";

    public static final String timeAndReportsTabXpath="(//a//span[@class='menu-item-link-text'])[9]";

}
