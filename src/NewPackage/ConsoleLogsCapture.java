package NewPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("/html/body/app-root/app-landingpage/div/p[2]/a")).click();
				
		driver.findElement(By.xpath("/html/body/app-root/app-product-details/div/div[2]/div/ul/div[1]/li/div/div/a")).click();

		driver.findElement(By.xpath("/html/body/app-root/app-product-shop/body/div[2]/div/div/div[2]/div[2]/button[1]")).click();

		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[3]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).clear();

		driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]")).sendKeys("3");

		LogEntries enteries= driver.manage().logs().get(LogType.BROWSER);
		
		List<LogEntry>logs= enteries.getAll();
		
		for(LogEntry e : logs) {
			System.out.println(e.getMessage());
		}
		
	}

}
