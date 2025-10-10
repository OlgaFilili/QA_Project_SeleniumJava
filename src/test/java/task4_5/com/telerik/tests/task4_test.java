package task4_5.com.telerik.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import task4_5.com.telerik.base.BaseTest;


public class task4_test extends BaseTest {

    @Test
    public void testSelectDropdown(){
        String Sport= "Volleyball";

        dropdownsPage.chooseFromAutocomplete(Sport);
        Assert.assertEquals(dropdownsPage.getSelectedSport(), Sport,
                "\n Input Sport And Selected Are Not The Same \n");
        dropdownsPage.clickDelete();
        Assert.assertEquals(dropdownsPage.getSelectedSport(), "",
                "\n The Field Is Not Empty \n");

    }
}
