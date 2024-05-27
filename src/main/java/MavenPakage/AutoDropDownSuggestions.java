package MavenPakage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoDropDownSuggestions {

	WebDriver driver;
	@BeforeClass
	public void launchBrowswer()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	@Test
	public void searchDropdown() throws InterruptedException
	{
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
		Thread.sleep(5000);
		List<WebElement> list = driver.findElements(By.xpath("//*[@role='listbox']//li//div[@role='option']"));
		System.out.println(list.size());
		
		for (int i=0; i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			if (list.get(i).getText().equals("selenium webdriver"))
			{
				Assert.assertEquals((list.get(i).getText()), "selenium webdriver");
				list.get(i).click();
				System.out.println("Test Status: Pass");
				break;
			}
		}
		

	}

	@AfterClass
	public void closeBowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();

	}
}
