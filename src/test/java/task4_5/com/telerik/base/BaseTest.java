package task4_5.com.telerik.base;

import com.telerik.pages.dropdowns.DropdownsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected DropdownsPage dropdownsPage;

    @BeforeClass
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openApp(){
        driver.get("https://demos.telerik.com/kendo-angular-ui/demos/dropdowns/overview?theme=default-main");
        dropdownsPage = new DropdownsPage(driver);
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}
