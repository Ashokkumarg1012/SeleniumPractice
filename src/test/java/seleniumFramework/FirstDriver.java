package seleniumFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FirstDriver {
	
	@Test
	public void firstDriver()
	{
		System.getProperty("webdriver.chrome.driver","C://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']")).click();
		WebElement ele = driver.findElement(By.id("searchDropdownBox"));
		
		Select dd = new Select(ele);
		dd.selectByValue("Books");
		
		
		
	}

}
