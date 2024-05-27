package MavenPakage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginToInstagramUsingExcelData {
	WebDriver driver;
	String src = "C:\\Selenium\\testData.xlsx";
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileInputStream fis;
	Object [][] data;
	
	@BeforeClass
	public void launBrowser()
	{
		driver = new EdgeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@DataProvider(name= "data")
	public Object[][] getDataFromExcel() throws IOException
	{
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(1);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(2).getLastCellNum();
		System.out.println("Number of Rows: "+rowCount + " And Number of Columns: "+colCount);
		data = new Object[rowCount][colCount];
		for( int i=0; i<rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		//wb.close();
		return data;
		
		
		
	}
	@Test(dataProvider="data")
	public void loginData(String un, String pwd) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys(un);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys(pwd);
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBowser()
	{
		driver.quit();
	}

	
}