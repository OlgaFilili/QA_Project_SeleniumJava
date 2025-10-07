package task1_2.com.telerik.base;

import com.telerik.pages.dialogs.DialogsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected DialogsPage dialogsPage;

    @BeforeClass
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openApp(){
        driver.get("https://demos.telerik.com/kendo-angular-ui/demos/dialogs/preview?theme=default-main");
        dialogsPage=new DialogsPage(driver);
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}
