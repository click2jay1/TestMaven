package sce1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptchaDemo {
	WebDriver driver;
	
	@Test
	public void mathCaptcha() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
		driver.manage().window().maximize();
		String text = driver.findElement(By.id("ebcaptchatext")).getText();
		System.out.println(text);
		String tx1 = text.substring(8,9);
		String tx2 = text.substring(12,13);
		String tx3 = text.substring(10,11);
		System.out.println(tx3);
	
		if (tx3.equals("+"))
		{
		Integer sum = Integer.valueOf(tx1) + Integer.valueOf(tx2);
		driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(sum));
		}
		else {
			Integer sub = Integer.valueOf(tx1) - Integer.valueOf(tx2);
			driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(sub));
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).click();
		Thread.sleep(2000);
		driver.quit();
	
	}
	
	
}
