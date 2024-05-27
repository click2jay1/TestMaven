package MavenPakage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CopyWebTabletoExcelSheet {
	WebDriver driver;
	String src = "C:\\Selenium\\tableData.xlsx";
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@BeforeClass
	public void launchBrowser()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
	}
	
	@Test
	public void copyTable() throws IOException
	{
		File file = new File(src);
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("Sheet1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement table = driver.findElement(By.id("customers"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		System.out.println("Total rows: " +allRows.size());
		
		for (int r=0; r<allRows.size();r++)
		{
			XSSFRow rowValue = sheet.createRow(r);
			System.out.println("Row number: "+r);
			List<WebElement> allCol = allRows.get(r).findElements(By.cssSelector("td, th"));

			for(int c=0;c<allCol.size(); c++)
			{
				String CellValue = allCol.get(c).getText();
				System.out.print(CellValue+"\t");
				rowValue.createCell(c).setCellValue(CellValue);
			}
			System.out.println();
			
		}
		wb.write(fos);
	//	wb.close();

		
		
	}
//	public void copyToExcel()
//	{
//		
//	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		driver.quit();
	}
}
