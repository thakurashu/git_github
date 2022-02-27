package NewPackage;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class MobileEmulator4Chrome {
	
public static void main(String...strings) throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
	
	ChromeDriver driver = new ChromeDriver();
	
	DevTools devtools= driver.getDevTools();
	
	devtools.createSession();
	
	devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 55, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
	
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("/html/body/app-root/nav/button/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[2]/a")).click();
}	

}
