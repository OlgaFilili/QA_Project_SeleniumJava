package com.telerik.pages.dropdowns;

import com.telerik.pages.BasePage;
import org.openqa.selenium.*;

import java.util.List;

import static utilities.Utils.*;

public class DropdownsPage extends BasePage {

    private By autocompleteField= By.xpath("//kendo-autocomplete[@placeholder='Your favorite sport']//input");
    private By deleteChosen= By.xpath("//span[@role='button']");

    private By multiSelect= By.xpath("//kendo-multiselect[@placeholder='Your favorite sports']//input");
    private By multiTags= By.xpath("By.cssSelector('kendo-multiselect kendo-taglist')");

    public DropdownsPage(WebDriver driver){
        super(driver);
        waitForPageToLoad(); // waits automatically when created
    }
    @Override
    protected By getPageIdentifier() {
        return autocompleteField;
    }

    public void chooseFromAutocomplete(String chooseSport) {
        WebElement input = find(autocompleteField);
        waitUntilClickable(driver, autocompleteField);
        input.clear();
        input.sendKeys(chooseSport);  // Type full value
        input.sendKeys(Keys.ENTER); // Confirm selection if required
    }
    public String getSelectedSport(){
        WebElement input = find(autocompleteField);
        String visibleValue = input.getAttribute("value");
        return visibleValue;
    }
    public void clickDelete(){
        WebElement clear= find(deleteChosen);
        waitUntilClickable(driver, deleteChosen);
        clear.click();

        // Wait until input is empty
        waitUntilAttributeToBe(driver, autocompleteField, "value", "");
    }

    public void chooseSportsJS(List<String> sports) {
        WebElement input = find(multiSelect);
        clickWithJS(driver, input);
        for(String sport : sports) {
            setValueWithJS(driver, input, sport);
            input.sendKeys(Keys.ENTER);
        }
    }
    public void clearAllSelectedSports() {
        WebElement input = find(multiSelect);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("let input = arguments[0]; " +
                        "let tags = input.closest('kendo-multiselect').querySelectorAll('.k-chip');" +
                        "tags.forEach(tag => tag.remove());" +
                        "input.value=''; input.dispatchEvent(new Event('input'));", input);
        waitForCondition(driver, () -> getSelectedSports().isEmpty());
    }
    public List<String> getSelectedSports() {
        WebElement tagList = find(multiTags);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<String> selected = (List<String>) js.executeScript(
                "let tags = arguments[0].querySelectorAll('.k-chip');" +
                        "return Array.from(tags).map(t => t.textContent.trim());", tagList);
        return selected;
    }
}
