package task1_2.com.telerik.tests;

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

        Assert.assertEquals(dialogsPage.getDialogTitle(), ExpectedTitle,
                "\n Actual & Expected Titles Do Not Match \n");
        Assert.assertEquals(dialogsPage.getDialogText(), ExpectedMessage,
                "\n Actual & Expected Messages Do Not Match \n");
        Assert.assertTrue(dialogsPage.dialogNoButtonIsDisplayed(),
                "\n There is No Button 'No' in Open Dialog \n");
        Assert.assertTrue(dialogsPage.dialogYesButtonIsDisplayed(),
                "\n There is No Button 'Yes' in Open Dialog \n");
        Assert.assertEquals(dialogsPage.colorVerify(), ExpectedColor,
                "\n Actual & Expected Colors of YesButton Do Not Match \n");

        dialogsPage.closeDialogByKeyboard();
        dialogsPage.returnToMainPageFromDialog();

        Assert.assertTrue(dialogsPage.mainElementIsDisplayed(),
                "\n Modal dialog Was Not Closed Properly \n");
    }
}
