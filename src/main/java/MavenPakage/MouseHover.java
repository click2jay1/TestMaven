package MavenPakage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}

	@Test(priority=1)
	public void dragable() 
	{
		driver.findElement(By.linkText("Draggable")).click();
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
		action.clickAndHold(drag).moveByOffset(100, 100).release().build().perform();
		//action.clickAndHold(drag).moveToLocation(20, 20).release().build().perform();
		
	}
	@Test(priority=2)
	public void dragAndDrop()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Droppable']")).click();
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();	
	}
	
	@Test(priority=3)
	public void resizable()
	{
		driver.findElement(By.linkText("Resizable")).click();
		driver.switchTo().frame(0);
		WebElement resize = driver.findElement(By.xpath("/html/body/div/div[3]"));
		Actions action = new Actions(driver);
		action.clickAndHold(resize).moveByOffset(200, 100).release().build().perform();
		
	}
	/*
	@Test(priority=4)
	public void selectable()
	{
		driver.findElement(By.linkText("Selectable")).click();
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.id("selectable"));
		Select opt = new Select(ele);
		opt.selectByIndex(0);
		
		
		WebElement item1 = driver.findElement(By.xpath("/html/body/ol/li[1]"));
		WebElement item4 = driver.findElement(By.xpath("/html/body/ol/li[4]"));
		WebElement item5 = driver.findElement(By.xpath("/html/body/ol/li[5]"));
		WebElement item7 = driver.findElement(By.xpath("/html/body/ol/li[7]"));
		Actions action = new Actions(driver);
		action.clickAndHold(item1).release().build().perform();
		action.clickAndHold(item4).release().build().perform();
		action.clickAndHold(item5).release().build().perform();
		
	}*/
	@Test(priority=5)
	public void sortable() throws InterruptedException
	{
		driver.findElement(By.linkText("Sortable")).click();
		driver.switchTo().frame(0);
		WebElement sort = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
		WebElement sortTo = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[4]"));
		Actions action = new Actions(driver);
		action.clickAndHold(sort).moveToElement(sortTo).release().build().perform();
		
		
	}

}
