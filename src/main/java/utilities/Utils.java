package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Utils {
    public static void waitUntilVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitUntilInvisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static void waitUntilClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForPopupStable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(d -> {
            WebElement popup = d.findElement(locator);
            return popup.isDisplayed() && "1".equals(popup.getCssValue("opacity"));
        });
    }
    public static File waitForFile(String filePath, int timeoutSeconds) {
        File file = new File(filePath);
        int waited = 0;

        while (waited < timeoutSeconds) {
            if (file.exists() && file.length() > 0) {
                return file;
            }
            try {
                Thread.sleep(500); // check every 0.5 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waited += 0.5;
        }
        return null;
    }
    public static int extractTotalItems(String text) {
        String[] parts = text.trim().split(" ");
        // The last part should be "items", the second-to-last part is the number
        return Integer.parseInt(parts[parts.length - 2]);
    }
}
