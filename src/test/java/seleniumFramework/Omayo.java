package seleniumFramework;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import webAutomation.utils.Base;

public class Omayo extends Base {
	
	@Test
	public void Select() throws InterruptedException
	{
		driver.get("https://omayo.blogspot.com/");
		
		/*
		 * WebElement ele =driver.findElement(By.xpath("//img[@alt='Electronics']"));
		 * hover(ele); driver.findElement(By.xpath("//a[text()='Soundbars']")).click();
		 * WebElement sel =
		 * driver.findElement(By.xpath("//option[@value='Max']//parent::select"));
		 * Select s = new Select(sel); s.selectByValue("25000"); WebElement ele1 =
		 * driver.findElement(By.xpath("//div[text()='Wired/Wireless']"));
		 * scrollTo(ele1);
		 * driver.findElement(By.xpath("//div[text()='Wired/Wireless']")).click();
		 * driver.findElement(By.xpath("//div[text()='Wired & Wireless']")).click();
		 * scrollTo(ele1);
		 * driver.findElement(By.xpath("//div[text()='Wired']")).click(); Boolean wired
		 * = driver.findElement(By.xpath(
		 * "//div[text()='Wired']//parent::label//child::input")).isSelected();
		 * System.out.println("Wired is selected"+wired);
		 * driver.findElement(By.xpath("//div[text()='Newest First']")).click();
		 * driver.findElement(By.
		 * xpath("//a[contains(text(),'ZEBRONICS ZEB-Juke bar 9530WS Pro Dolby 5.1')]"))
		 * .click();
		 * 
		 */		
		
		/*
		 * driver.findElement(By.xpath("//div//input[@name='q']")).sendKeys("speakers");
		 * List<WebElement> list=driver.findElements(By.xpath("//ul//child::li"));
		 * for(WebElement e:list) { if(e.getText()=="boat speaker") { e.click();
		 * System.out.println("Clicked successfully"); } } String text =
		 * driver.findElement(By.xpath("//span[text()='boat speaker']")).getText();
		 * System.out.println(text);
		 */
		
		WebElement ele=driver.findElement(By.id("drop1"));
		Select ss=new Select(ele);
		List<WebElement> i=ss.getOptions();
		for(WebElement l:i)
		{
			System.out.println(l.getText());
			
		}
		ss.selectByIndex(2);
//		ss.selectByValue("jkl");
		
		WebElement ele2=driver.findElement(By.id("multiselect1"));
		Select s2=new Select(ele2);
		List<WebElement> m=s2.getOptions();
		for(WebElement l:m)
		{
			System.out.println(l.getText());
		}
		int size=m.size();
		for(int j=0;j<size;j++)
		{
			s2.selectByIndex(j);
			
		}
		
		
		
	}
	
	@Test
	public void dropdown()
	{
		WebElement ele=driver.findElement(By.xpath("//button[@class='dropbtn']"));
		scrollTo(ele);
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='myDropdown']//a"));
		Iterator<WebElement> it= list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	@Test
	public void isButtonEnabled()
	{
		WebElement ele= driver.findElement(By.xpath("//button[@id='but1']"));
		if(ele.isEnabled())
		{
			ele.click();
		}
		else
			System.out.println("Button is disabled");
			
			
	}
	
	@Test
	public void uploadFile()
	{
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		File uploadfile= new File("C://Users//Ashok//eclipse-workspace//webAutomation//Resource//selenium-snapshot.png");
		WebElement fileInput = driver.findElement(By.xpath("//input[@id='file-upload']"));
//		fileInput.sendKeys(uploadfile);
	}

}
