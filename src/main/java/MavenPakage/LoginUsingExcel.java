package MavenPakage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginUsingExcel {
	WebDriver driver;
	String src = "C:\\Selenium\\testData.xlsx";
	Object[][] data;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileInputStream fis;
	
	@DataProvider(name="data")
	public Object[][] readFromExcel() throws IOException
	{
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook (fis);
		sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		data = new Object[rowCount][colCount];
		
		for (int i=0; i<rowCount;i++)
		{
			for (int j=0; j<colCount; j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
//	wb.close();
		return (data);
	}
	
	
	
	@BeforeClass
	public void launchBrowser()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		
		
	}
	
	@Test(dataProvider = "data")
	public void login(String un, String pwd) throws InterruptedException
	{
		driver.findElement(By.id("login1")).clear();
		driver.findElement(By.id("login1")).sendKeys(un);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}

}
