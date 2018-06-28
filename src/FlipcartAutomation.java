import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipcartAutomation {
private static List<WebElement> findElements;
private static String windowHandle;
private static Set<String> windowHandles;
private static String text;

public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:/Users/Raghu/workspace1/Flipcart2/Driver/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/?affid=runixmail");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	driver.findElement(By.name("q")).sendKeys("Samsung Galaxy");
	driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
	findElements = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
	int elementSize=findElements.size();
	String itemName="";
	String itemText="";
	for(int i=0;i<=elementSize;i++)
	{
		itemName=findElements.get(i).getText();
		System.out.println(itemName);
		if(i==6)
		{
			findElements.get(i).click();
		 itemText=itemName;
			break;
		}
	}
	windowHandle = driver.getWindowHandle();
	windowHandles = driver.getWindowHandles();
	for(String x : windowHandles)
	{
		if(!windowHandle.equals(x))
			driver.switchTo().window(x);
		
	}
	
	//WebDriverWait wait = new WebDriverWait(driver, 60);
	
	driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
	//wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	//Thread.sleep(3000);
	text = driver.findElement(By.xpath("//a[@class='_325-ji _3ROAwx']")).getText();
	if(text.equals(itemText))
	{
		System.out.println(true);
	}
	
}
}
