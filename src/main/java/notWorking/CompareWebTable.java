package notWorking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareWebTable {

	WebDriver driver;
	ArrayList<String> exp_data=new ArrayList<String>();
	ArrayList<String> act_data=new ArrayList<String>();
	FileReader fr;
	BufferedReader br;
	String src="C:\\Arpana\\Training\\Sel2\\jay\\data.txt";
	@Test(priority=1)
	public void readFrmTxtFile() throws IOException
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String content=null;
		while((content=br.readLine())!=null)
		{
			exp_data.add(content);
		}
		br.close();
		
	}
	@Test(priority=2)
	public void readFromWebTable()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		WebElement myTable=driver.findElement(By.id("customers"));
		List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("Total Number of Rows="+allRows.size());
		for(int i=1;i<allRows.size();i++)  //focus Row
		{
			List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<allCols.size();j++)
			{
				act_data.add(allCols.get(j).getText());
			}
			
		}
		driver.quit();

	}
	@Test(priority=3)
	public void compare()
	{
		for(int i=0;i<exp_data.size();i++)
		{
//			if(exp_data.get(i).equals(act_data.get(i))) {
//				
//				System.out.println("Item Matched...");
//			}
//			else
//			{
//				System.out.println("Item not Matched...");
//			}
			Assert.assertEquals(exp_data.get(i),act_data.get(i ));
			System.out.println("Asser Executed..");
		}
	}
}
