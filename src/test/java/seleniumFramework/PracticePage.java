package seleniumFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import webAutomation.utils.Base;

public class PracticePage extends Base {
	
	@Test(priority=1)
	public void radioButton() throws InterruptedException
	{
		
//		String title = driver.getTitle();
//		System.out.println(title);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
		List<WebElement> radioButtons = driver.findElements(By.className("radioButton"));
		
		for(WebElement i:radioButtons) 
		{
			i.click();
			
		}
		radioButtons.get(1).click();
	
	}
	
	@Test(priority=2)
	public void suggestions()
	{
		driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']")).sendKeys("Ant");
		driver.findElement(By.xpath("//div[text()='Antarctica']")).click();
	}
	
	@Test(priority=3)
	public void dropdown()
	{
		driver.findElement(By.xpath("//select[@name='dropdown-class-example']")).click();
		WebElement dd = driver.findElement(By.xpath("//select[@name='dropdown-class-example']"));
		Select s = new Select(dd);
		s.selectByValue("option3");
		
	}
	
	@Test(priority=4)
	public void checkbox()
	{
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption2")).click();
	}
	
	@Test(priority=5)
	public void windowHandles() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[contains(text(),\"Open Window\")]")).click();
		String parentId = driver.getWindowHandle();
		System.out.println("Parent Id: "+parentId);
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> it = allwindows.iterator();
		while(it.hasNext())
		{
			String child=it.next();
			if(!child.equals(parentId))
			{
				String title = driver.switchTo().window(child).getTitle();
				System.out.println(child);
				System.out.println(title);
				driver.close();
			}
		}
		driver.switchTo().window(parentId);
		
	
		
	}
	
	@Test(priority=6)
	public void switchTab() throws InterruptedException
	{
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//legend[@class='switch-tab']//following-sibling::a")).click();
		
		driver.switchTo().window(parent);
		System.out.println("Switch tabs: "+driver.getTitle());
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
		driver.switchTo().window(parent);

		System.out.println("Back to parent window: "+driver.getTitle());
		
	}
	
	@Test(priority=7)
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
	@Test(priority=8)
	public void scrollAction() throws InterruptedException
	{
		WebElement ele = driver.findElement(By.xpath("//legend[text()='Web Table Fixed header']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
		
		js.executeScript("window.scrollBy(0,1000)");
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
	}
	
	@Test(priority=9)
	public void elementVisibility()
	{
		WebElement el = driver.findElement(By.xpath("//legend[text()='Element Displayed Example']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", el);
		driver.findElement(By.xpath("//input[@value='Show']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@placeholder='Hide/Show Example']"));
		isDisplayed(ele);
		driver.findElement(By.xpath("//input[@value='Hide']")).click();
		isDisplayed(ele);
		
	}
	
	@Test(priority=10)
	public void mousehover() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//legend[text()='Mouse Hover Example']")));
		WebElement ele = driver.findElement(By.xpath("//legend[text()='Mouse Hover Example']//following::button"));
		hover(ele);
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='mouse-hover-content']//child::a"));
		for(WebElement i:list)
		{
			System.out.println("Hover item: "+i.getText());
		}
		
	}
	
	@Test(priority=11)
	public void frames()
	{
		WebElement ele = driver.findElement(By.xpath("//legend[text()='iFrame Example']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
		driver.switchTo().frame("iframe-name");
		Boolean login=driver.findElement(By.xpath("//a[@class='theme-btn register-btn']")).isDisplayed();
		Assert.assertTrue(login);
		driver.switchTo().parentFrame();
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Boolean display=driver.findElement(By.xpath("//a[text()='Discount Coupons']")).isDisplayed();
		System.out.println("Discount Coupons is displayed: "+display);
	}
	
	@Test(priority=12)
	public void table() throws IOException
	{
		
		WebElement ele =driver.findElement(By.xpath("//legend[text()='Web Table Fixed header']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollToView", ele);
		takeScreenshot();
		List<WebElement> tableHead = driver.findElements(By.xpath("//div[@class='tableFixHead']//table//thead//tr"));
		for(WebElement h:tableHead)
		{
			System.out.print(h.getText()+" ");
		}
		System.out.println(" " );
		List<WebElement> tablebody = driver.findElements(By.xpath("(//div[@class='tableFixHead']//table//tbody//tr)[5]"));
		for(WebElement b:tablebody)
		{
			System.out.println(b.getText()+" ");
			
		}
		System.out.println(" ");
		
	}
	
	
	

}
