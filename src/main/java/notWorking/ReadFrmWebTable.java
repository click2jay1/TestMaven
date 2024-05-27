package notWorking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadFrmWebTable {
	WebDriver driver;
	String src="C:\\Arpana\\Training\\Sel2\\jay\\data.txt";
	FileWriter fw;
	BufferedWriter bw;
	@BeforeClass
	public void launch()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
	}

	@Test
	public void readWebTable() throws IOException
	{
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		WebElement myTable=driver.findElement(By.id("customers"));
		List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("Total Number of Rows="+allRows.size());
		for(int i=1;i<allRows.size();i++)  //focus Row
		{
			List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<allCols.size();j++)
			{
				//System.out.println(allCols.get(j).getText());
				bw.write(allCols.get(j).getText());
				bw.newLine();
			}
			
		}
		bw.close();
		
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
}
