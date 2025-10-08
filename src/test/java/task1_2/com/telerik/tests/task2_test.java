package task1_2.com.telerik.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import task1_2.com.telerik.base.BaseTest;

public class task2_test extends BaseTest {

    @Test
    public void testOpenWindowButton(){
        String ExpectedTitle= "About";
        String ExpectedMessage= "Additional info";
        dialogsPage.clickOpenwindowButton();

        Assert.assertEquals(dialogsPage.getWindowTitle(), ExpectedTitle,
                "\n Actual & Expected Titles Do Not Match \n");
        Assert.assertEquals(dialogsPage.getWindowText(), ExpectedMessage,
                "\n Actual & Expected Messages Do Not Match \n");
        Assert.assertTrue(dialogsPage.windowMininizeButtonIsDisplayed(),
                "\n There is No Minimize Button in Open Window \n");
        Assert.assertTrue(dialogsPage.windowMaximizeButtonIsDisplayed(),
                "\n There is No Maximize Button in Open Window \n");
        Assert.assertTrue(dialogsPage.windowCloseButtonIsDisplayed(),
                "\n There is No Close Button in Open Window \n");

        dialogsPage.clickMaximizeButton();

        Assert.assertTrue(dialogsPage.windowRestoreButtonIsDisplayed(),
                "\n There is Restore Button in Open Window \n");
        Assert.assertFalse(dialogsPage.windowMaximizeButtonIsDisplayed(),
                "\n There is Maximize Button in Open Window \n");

        dialogsPage.clickCloseButton();
        dialogsPage.returnToMainPageFromWindow();

        Assert.assertTrue(dialogsPage.mainElementIsDisplayed(),
                "\n Window Was Not Closed Properly \n");


    }
}
