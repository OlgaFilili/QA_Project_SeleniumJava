package com.telerik.pages.dialogs;

import com.telerik.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import static utilities.Utils.*;

public class DialogsPage extends BasePage {
    private By opendialogButton= By.xpath("//span[text()='Open dialog']");
    private By openwindowButton= By.xpath("//span[text()='Open window']");
    private By opendialogTitle= By.cssSelector("span[id*='kendo-dialog-title-']");
    //private By closedialogButton=By.xpath("//button[@title='Close']");
    private By opendialogText= By.cssSelector("div[id*='kendo-dialog-content-'] p");
    private By opendialogNoButton= By.xpath("//kendo-dialog-actions//span[text()='No']");
    private By opendialogYesButton= By.xpath("//kendo-dialog-actions//span[text()='Yes']");
    private By opendialogYesButtonColorTheme= By.cssSelector("button[themecolor='primary']");

    public DialogsPage(WebDriver driver){
        super(driver);
        waitForPageToLoad(); // waits automatically when created
    }
    @Override
    protected By getPageIdentifier() {
        return opendialogButton;
    }

    public void clickOpendialogButton(){
        click(opendialogButton);
    }

    public String getTitle(){
        return find(opendialogTitle).getText();
    }
    public String getText(){
        return find(opendialogText).getText();
    }

    public void pressCloseButton(){
        Actions act=new Actions(driver);
        act.sendKeys(Keys.chord(Keys.TAB, Keys.ENTER)).perform();
    }

    public boolean opendialogNoButtonIsDisplayed(){
        return find(opendialogNoButton).isDisplayed();
    }

    public boolean opendialogYesButtonIsDisplayed(){
        return find(opendialogYesButton).isDisplayed();
    }

    public String ColorVerify() {
        return getColorValue(opendialogYesButtonColorTheme, "background-color");
    }

    public void returnToMainPage(){
        waitUntilInvisible(driver, opendialogTitle, 5);
        waitUntilVisible(driver, opendialogButton, 5);
    }
    public boolean isMainElementVisible() {
        return find(opendialogButton).isDisplayed();
    }

    public void clickOpenwindowButton(){
        click(openwindowButton);
    }
}
