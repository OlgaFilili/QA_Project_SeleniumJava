package com.telerik.pages.dialogs;

import com.telerik.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import static utilities.Utils.*;

public class DialogsPage extends BasePage {
    private By opendialogButton= By.xpath("//span[text()='Open dialog']");
    private By dialogTitle= By.cssSelector("span[id*='kendo-dialog-title-']");
    //private By closedialogButton=By.xpath("//button[@title='Close']");
    private By dialogText= By.cssSelector("div[id*='kendo-dialog-content-'] p");
    private By dialogNoButton= By.xpath("//kendo-dialog-actions//span[text()='No']");
    private By dialogYesButton= By.xpath("//kendo-dialog-actions//span[text()='Yes']");
    private By dialogYesButtonColorTheme= By.cssSelector("button[themecolor='primary']");

    private By openwindowButton= By.xpath("//span[text()='Open window']");
    private By windowTitle= By.cssSelector("span[id*='kendo-window-title-']");
    private By windowText= By.xpath("//p[text()='Additional info']");
    private By minimizeWindowButton= By.xpath("//button[@title='Minimize']");
    private By maximizeWindowButton= By.xpath("//button[@title='Maximize']");
    private By closeWindowButton= By.xpath("//button[@title='Close']");
    private By restoreWindowButton= By.xpath("//button[@title='Restore']");

    public DialogsPage(WebDriver driver){
        super(driver);
        waitForPageToLoad(); // waits automatically when created
    }
    @Override
    protected By getPageIdentifier() {
        return opendialogButton;
    }

    public boolean mainElementIsDisplayed() {
        return find(opendialogButton).isDisplayed();
    }

    public void clickOpendialogButton(){
        click(opendialogButton);
    }
    public String getDialogTitle(){
        return find(dialogTitle).getText();
    }
    public String getDialogText(){
        return find(dialogText).getText();
    }
    public boolean dialogNoButtonIsDisplayed(){
        return find(dialogNoButton).isDisplayed();
    }
    public boolean dialogYesButtonIsDisplayed(){
        return find(dialogYesButton).isDisplayed();
    }
    public String colorVerify() {
        return getColorValue(dialogYesButtonColorTheme, "background-color");
    }
    public void closeDialogByKeyboard(){
        Actions act=new Actions(driver);
        act.sendKeys(Keys.chord(Keys.TAB, Keys.ENTER)).perform();
    }
    public void returnToMainPageFromDialog(){
        waitUntilInvisible(driver, dialogTitle, 5);
        waitUntilVisible(driver, opendialogButton, 5);
    }


    public void clickOpenwindowButton(){
        click(openwindowButton);
    }
    public String getWindowTitle(){
        return find(windowTitle).getText();
    }
    public String getWindowText(){
        return find(windowText).getText();
    }
    public boolean windowMininizeButtonIsDisplayed(){
        return find(minimizeWindowButton).isDisplayed();
    }
    public boolean windowMaximizeButtonIsDisplayed(){
        return find(maximizeWindowButton).isDisplayed();
    }
    public boolean windowCloseButtonIsDisplayed(){
        return find(closeWindowButton).isDisplayed();
    }
    public boolean windowRestoreButtonIsDisplayed(){
        return find(restoreWindowButton).isDisplayed();
    }
    public void clickMaximizeButton(){
        click(maximizeWindowButton);
    }
    public void clickCloseButton(){
        click(closeWindowButton);
    }
    public void returnToMainPageFromWindow(){
        waitUntilInvisible(driver, windowTitle, 5);
        waitUntilVisible(driver, opendialogButton, 5);
    }

}
