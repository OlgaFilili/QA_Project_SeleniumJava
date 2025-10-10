package com.telerik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Each page defines its own identifier
    protected abstract By getPageIdentifier();

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPageIdentifier()));
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected List<WebElement> finds(By locator){
        return driver.findElements(locator);
    }
    protected void click(By locator){
        find(locator).click();
    }
    protected String getColorValue(By locator, String CSSProperty) {
        String colorCode= find(locator).getCssValue(CSSProperty);
        return Color.fromString(colorCode).asRgb();
    }
    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

}
