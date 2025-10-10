package task3.com.telerik.base;

import com.telerik.pages.grid.GridPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;
    protected GridPage gridPage;

    @BeforeClass
    public void setUp(){
        // Define download folder inside project
        String downloadFilepath = System.getProperty("user.dir") + "\\downloads";
        new File(downloadFilepath).mkdirs();

        // Chrome preferences
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("safebrowsing.enabled", true);

        // Chrome options
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        // Create driver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openApp(){
        driver.get("https://demos.telerik.com/kendo-angular-ui/demos/grid/filter-all-columns?theme=default-main");
        gridPage=new GridPage(driver);
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
