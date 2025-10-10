package task3.com.telerik.tests;

import com.telerik.pages.grid.GridPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import task3.com.telerik.base.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import static utilities.Utils.*;

public class task3_test extends BaseTest {

    @Test
    public void testExportFilterTableValues(){
        String downloadPath = System.getProperty("user.dir") + "\\downloads\\Employees.xlsx";
        String country= "US";
        String ExpectedOperator="Is equal to";
        String[] headers= {
                "Contact Name",
                "Job Title",
                "Country",
                "Status",
                "Rating",
                "Engagement",
                "Budget",
                "Phone",
                "Address"
        };

        gridPage.selectCountryColumnMenu();
        gridPage.filterChooseCountryOperator1();
        Assert.assertEquals(gridPage.getSelectedOperator1(), ExpectedOperator,
                "\n CountryColumnOperator Is Not 'Is equal to' \n");
        gridPage.filterCountry1(country);
        gridPage.clickFilterButton();
        gridPage.mainElementIsDisplayed();

        gridPage.selectStatusColumnMenu();
        gridPage.chooseOnlineStatus();
        gridPage.mainElementIsDisplayed();

        gridPage.selectStatusColumnMenu();
        gridPage.chooseColumnsForPrint();
        gridPage.clickColumnCheckbox(headers[2]);
        gridPage.clickColumnCheckbox(headers[3]);
        gridPage.clickColumnCheckbox(headers[4]);
        gridPage.clickColumnCheckbox(headers[5]);
        gridPage.clickColumnCheckbox(headers[6]);
        gridPage.clickApplyColumnsButton();
        gridPage.mainElementIsDisplayed();
        Assert.assertTrue(gridPage.columnHeaderIsPresent(headers[0]),
                "\n "+ headers[0]+ " Is Not Displayed \n");
        Assert.assertTrue(gridPage.columnHeaderIsPresent(headers[1]),
                "\n "+ headers[1]+ " Is Not Displayed \n");
        Assert.assertFalse(gridPage.columnHeaderIsPresent(headers[2]),
                "\n "+ headers[2]+ " Is Displayed \n");
        Assert.assertFalse(gridPage.columnHeaderIsPresent(headers[3]),
                "\n "+ headers[3]+ " Is Displayed \n");
        Assert.assertFalse(gridPage.columnHeaderIsPresent(headers[4]),
                "\n "+ headers[4]+ " Is Displayed \n");
        Assert.assertFalse(gridPage.columnHeaderIsPresent(headers[5]),
                "\n "+ headers[5]+ " Is Displayed \n");
        Assert.assertFalse(gridPage.columnHeaderIsPresent(headers[6]),
                "\n "+ headers[6]+ " Is Displayed \n");
        Assert.assertTrue(gridPage.columnHeaderIsPresent(headers[7]),
                "\n "+ headers[7]+ " Is Not Displayed \n");
        Assert.assertTrue(gridPage.columnHeaderIsPresent(headers[8]),
                "\n "+ headers[8]+ " Is Not Displayed \n");

        int BrowserRowsNumber= gridPage.findAmountOfRows();
        int BrowserColumnsNumber= 4;
        //System.out.println("Download folder: " + downloadPath);
        gridPage.exportToExcelByKeyboard();
        File file=waitForFile(downloadPath, 5);
        Assert.assertTrue(file.exists(), "Exported Excel file not found!");

        // Read Excel contents
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int ExcelRowsNumber = sheet.getPhysicalNumberOfRows()-2; // first 2 rows are headers
            int ExcelColumnsNumber = sheet.getRow(2).getPhysicalNumberOfCells();
            Assert.assertEquals(ExcelColumnsNumber, BrowserColumnsNumber, "\n Column Count Mismatch Between Excel And Browser \n");
            Assert.assertEquals(ExcelRowsNumber, BrowserRowsNumber, "\n Row Count Mismatch Between Excel And Browser \n");

            //Verify Phone numbers in random row in Excel
            GridPage.CellData phoneData = gridPage.getPhoneFromRandomRow();
            int rowIndex = phoneData.rowIndex();
            String browserPhone = phoneData.cellValue();
            // Get same row from Excel
            Row excelRow = sheet.getRow(rowIndex + 2); // first 2 rows are headers
            Cell excelCell = excelRow.getCell(2);     // Phone column index
            String excelPhone = excelCell.getStringCellValue().trim();
            Assert.assertEquals(excelPhone, browserPhone, "\n Phone Values Mismatch Between Excel And Browser \n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
