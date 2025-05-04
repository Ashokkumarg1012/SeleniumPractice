package seleniumFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import webAutomation.utils.Base;

public class ShoppingWebsit {
	
	@Test
	public void shopping()
	{
		System.getProperty("webdriver.chrome.driver","C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("shoes");
		driver.findElement(By.xpath("//div[@id='sac-suggestion-row-1']")).click();
		String item = driver.findElement(By.xpath("//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")).getDomAttribute("text");
//		driver.findElement(By.xpath("//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")).click();
		driver.findElement(By.xpath("//span[@id='a-autoid-1']")).click();
		String itemInCart=driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-none a-color-base a-text-normal']")).getDomAttribute("text");
		Assert.assertEquals(item, itemInCart);


	}
	
	

}
