package task1_2.com.telerik.tests;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import task1_2.com.telerik.base.BaseTest;

public class task1_test extends BaseTest {

    @Test
    public void testOpenDialogButton(){
        String ExpectedTitle= "Please confirm";
        String ExpectedMessage= "Are you sure you want to continue?";
        String ExpectedColor= "rgb(255, 99, 88)";
        dialogsPage.clickOpendialogButton();

        Assert.assertEquals(dialogsPage.getTitle(), ExpectedTitle,
                "\n Actual & Expected Titles Do Not Match \n");
        Assert.assertEquals(dialogsPage.getText(), ExpectedMessage,
                "\n Actual & Expected Messages Do Not Match \n");
        Assert.assertTrue(dialogsPage.opendialogNoButtonIsDisplayed(),
                "\n There is No Button 'No' in Open Dialog \n");
        Assert.assertTrue(dialogsPage.opendialogYesButtonIsDisplayed(),
                "\n There is No Button 'Yes' in Open Dialog \n");
        Assert.assertEquals(dialogsPage.ColorVerify(), ExpectedColor,
                "\n Actual & Expected Colors of YesButton Do Not Match \n");

        dialogsPage.pressCloseButton();
        dialogsPage.returnToMainPage();

        Assert.assertTrue(dialogsPage.isMainElementVisible(),
                "\n Modal dialog Not Closed Properly \n");





    }
}
