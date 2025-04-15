package seleniumFramework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import webAutomation.utils.Base;

public class FirstDriver extends Base {
	
	@Test(priority =1)
	public void radioButton() throws InterruptedException
	{
		
//		String title = driver.getTitle();
//		System.out.println(title);
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
		List<WebElement> radioButtons = driver.findElements(By.className("radioButton"));
		
		for(WebElement i:radioButtons) 
		{
			i.click();
			Thread.sleep(2000);
			
		}
		radioButtons.get(1).click();
	
	}
	
	@Test(priority =2)
	public void suggestions()
	{
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("Ant");
		driver.findElement(By.xpath("//div[text()='Antarctica']")).click();
	}
	
	@Test(priority =3)
	public void dropdown()
	{
		driver.findElement(By.xpath("//select[@name='dropdown-class-example']")).click();
		WebElement dd = driver.findElement(By.xpath("//select[@name='dropdown-class-example']"));
		Select s = new Select(dd);
		s.selectByValue("option3");
		
	}
	
	@Test(priority =4)
	public void checkbox()
	{
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
	}
	
	@Test(priority =5)
	public void windowHandles() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[contains(text(),\"Open Window\")]")).click();
		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		
		for(String set:handles)
		{
			if(!set.equalsIgnoreCase(parent)) 
			{
				driver.switchTo().window(set);
			}
			String title = driver.getTitle();
//			System.out.println(title);
			
			driver.switchTo().window(parent);
//			System.out.println(driver.getTitle());
			
		}
	}
	
	@Test(priority =6)
	public void switchTab() throws InterruptedException
	{
		driver.findElement(By.xpath("//legend[@class='switch-tab']//following-sibling::a")).click();
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> it = tabs.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			if(driver.getTitle().equals("QAClick Academy - A Testing Academy to Learn, Earn and Shine")) {
				System.out.println("found desired tab");
				break;
				
			}
		}

		System.out.println(driver.getTitle());
		Thread.sleep(2000);
	}
	
	@Test(priority =7)
	public void alerts()
	{
		driver.findElement(By.xpath("//legend[text()='Switch To Alert Example']//following-sibling::input[@id='name']")).sendKeys("Pratham");
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert text: "+alertText);
		driver.switchTo().alert().dismiss();
		
	}
	
	
	

}
