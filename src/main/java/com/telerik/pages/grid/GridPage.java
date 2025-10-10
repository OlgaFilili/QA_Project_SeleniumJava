package com.telerik.pages.grid;

import com.telerik.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

import static utilities.Utils.*;

public class GridPage extends BasePage {
    private By exportToExcelButton= By.xpath("//button[.//span[text()='Export to Excel']]");
    private By countryColumnMenu= By.xpath("//a[contains(@title, 'Country')]//kendo-svgicon[@aria-hidden='true']");
    private By columnFilter=By.xpath("//kendo-grid-columnmenu-item[@icon='filter']//div[@role='button']");
    private static final String countrydropdownOperatorBase1 = "//kendo-dropdownlist[contains(@aria-label, 'Country')][1]";
    private By countrydropdownOperatorsMenuItem1=By.xpath(countrydropdownOperatorBase1);
    private By countrydropdownChooseOperator1=By.xpath(countrydropdownOperatorBase1+"//span[text()='Is equal to']");
    private By countrydropdownchooseCountry1= By.xpath("(//kendo-textbox//input[@aria-label='Country Filter'])[1]");
    private By filterButton=By.xpath("//button[text()='Filter']");

    private By statusColumnMenu= By.xpath("//a[contains(@title, 'Status')]//kendo-svgicon[@aria-hidden='true']");
    private By radioButtonIsTrue= By.xpath("//li//label[text()='Is True']");
    private By columnColumns=By.xpath("//kendo-grid-columnmenu-item[@icon='columns']//div[@role='button']");
    private By applyColumnsButton= By.xpath("//button//span[text()='Apply']");

    private By pagesInfo=By.xpath("//kendo-pager-info");

    public GridPage(WebDriver driver){
        super(driver);
        waitForPageToLoad(); // waits automatically when created
    }
    @Override
    protected By getPageIdentifier() {
        return exportToExcelButton;
    }

    public boolean mainElementIsDisplayed() {
        return find(exportToExcelButton).isDisplayed();
    }
    public void selectCountryColumnMenu(){
        click(countryColumnMenu);
    }
    public void chooseCountryOperatorByKeyboard(){
        Actions act=new Actions(driver);
        act.sendKeys(Keys.chord(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ENTER)).perform();
    }
    public void filterChooseCountryOperator1() {
        click(columnFilter);
        waitForPopupStable(driver, columnFilter);
        click(countrydropdownOperatorsMenuItem1);
        waitForPopupStable(driver, columnFilter);
        chooseCountryOperatorByKeyboard();
    }
    public String getSelectedOperator1() {
        return find(countrydropdownChooseOperator1).getText();
    }
    public void filterCountry1(String country){
        click(countrydropdownchooseCountry1);
        set(countrydropdownchooseCountry1, country);
    }
    public void clickFilterButton(){
        click(filterButton);
    }

    public void selectStatusColumnMenu(){
        click(statusColumnMenu);
    }
    public void chooseOnlineStatus(){
        waitForPopupStable(driver, columnFilter);
        click(columnFilter);
        waitForPopupStable(driver, radioButtonIsTrue);
        click(radioButtonIsTrue);
        waitForPopupStable(driver, filterButton);
        clickFilterButton();
    }

    public void clickColumnCheckbox(String checkboxName) {
        By locator= By.xpath("//label[.//span[text()='"+ checkboxName+ "']]//input[@type='checkbox']");
        WebElement checkbox = find(locator);
        boolean isChecked = checkbox.getAttribute("class").contains("k-checked"); // Kendo adds this in class when checked
        if (isChecked) {
            checkbox.click(); // toggles off
        }
    }
    public void clickApplyColumnsButton(){
        //waitForPopupStable(driver, columnColumns);
        click(applyColumnsButton);
    }
    public void chooseColumnsForPrint(){
        waitForPopupStable(driver, columnColumns);
        click(columnColumns);
        waitForPopupStable(driver, columnColumns);
    }
    public boolean columnHeaderIsPresent(String columnName) {
        By locator = By.xpath("//th[@aria-label='" + columnName + "']");
        List<WebElement> elements = finds(locator);
        return !elements.isEmpty();
    }

    public void exportToExcelByKeyboard(){
        Actions act=new Actions(driver);
        act.moveToElement(find(exportToExcelButton)).click().perform(); // ensures focus
        act.sendKeys(Keys.ENTER).perform();
    }
    public int findAmountOfRows(){
        return extractTotalItems(find(pagesInfo).getText());
    }
    public record CellData(int rowIndex, String cellValue){}
    //Verify Phone numbers in random row in Browser
    public CellData getPhoneFromRandomRow() {
        // Get all rows
        List<WebElement> rows = finds(By.cssSelector("tbody tr"));
        // Pick a random row
        Random rand = new Random();
        int randomRowIndex = rand.nextInt(rows.size());
        WebElement randomRow = rows.get(randomRowIndex);
        // Get Phone cell by column index
        WebElement phoneCell = randomRow.findElement(By.cssSelector("td[data-kendo-grid-column-index='3']"));
        String phoneValue = phoneCell.getText().trim();
        return new CellData(randomRowIndex, phoneValue);
    }
}
