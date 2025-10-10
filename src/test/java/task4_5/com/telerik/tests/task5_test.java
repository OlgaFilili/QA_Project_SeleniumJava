package task4_5.com.telerik.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import task4_5.com.telerik.base.BaseTest;

import java.util.Arrays;
import java.util.List;

public class task5_test extends BaseTest {

    @Test
    public void testMultiSelectDropdown() {

        dropdownsPage.clearAllSelectedSports();
        List<String> afterClear = dropdownsPage.getSelectedSports();
        Assert.assertTrue(afterClear.isEmpty(),
                "\n MultiSelect Selected List Is Not Empty \n");

        List<String> newSports = Arrays.asList("Tennis", "Football");
        dropdownsPage.chooseSportsJS(newSports);

        List<String> selected = dropdownsPage.getSelectedSports();
        Assert.assertTrue(selected.containsAll(newSports),
                "\n Expected And Actual Selected Sports Are Not The Same \n");
    }
}
