package testsuite;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagefactories.HomePage;
import pagefactories.RegisterPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CompleteRegisterPage {

    WebDriver driver;
    RegisterPage registerObj;
    HomePage homeObj;
    String baseUrl = "http://demo.guru99.com/test/newtours/index.php";

    @BeforeTest
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/nabilamin/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        registerObj = new RegisterPage(driver);
        homeObj = new HomePage(driver);
        homeObj.clickRegister();
    }

    @Test
    public void test() throws IOException
    {
        File file = new File("/Users/nabilamin/Downloads/mercuryTours.xlsx");

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheet("Sheet1");

        int rowsUsed = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 1; i <= rowsUsed; i++)
        {
            Row row = sheet.getRow(i);
            for (int j = 0; j <= row.getLastCellNum(); j++)
            {
                switch (j)
                {
                    case 0:
                    registerObj.fillFirstNameField(row.getCell(j).getStringCellValue());
                    break;
                    case 1:
                        registerObj.fillLastNameField(row.getCell(j).getStringCellValue());
                        break;
                    case 2:
                        registerObj.fillPhoneNumberField(row.getCell(j).getStringCellValue());
                        break;
                    case 3:
                        registerObj.fillEmailField(row.getCell(j).getStringCellValue());
                        break;
                    case 4:
                        registerObj.fillStreetField(row.getCell(j).getStringCellValue());
                        break;
                    case 5:
                        registerObj.fillCityField(row.getCell(j).getStringCellValue());
                        break;
                    case 6:
                        registerObj.fillStateField(row.getCell(j).getStringCellValue());
                        break;
                    case 7:
                        registerObj.fillZipCodeField(row.getCell(j).getStringCellValue());
                        break;
                    case 8:
                        registerObj.setCountryField(row.getCell(j).getStringCellValue());
                        break;
                    case 9:
                        registerObj.fillUserNameField(row.getCell(j).getStringCellValue());
                        break;
                    case 10:
                        registerObj.fillPasswordField(row.getCell(j).getStringCellValue());
                        break;
                }
            }
            registerObj.submitForm();
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b")).getText(),"Note: Your user name is " + row.getCell(9).getStringCellValue() + ".");
            driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");
        }
    }

    @AfterTest
    public void cleanUp()
    {
        driver.close();
    }

}
