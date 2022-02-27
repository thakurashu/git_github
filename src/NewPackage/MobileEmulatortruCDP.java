package NewPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class MobileEmulatortruCDP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devtools= driver.getDevTools();
		
		devtools.createSession();
		
		Map map = new HashMap();
		map.put("width", 600);
		map.put("height", 1000);
		map.put("deviceScaleFactor", 60);
		map.put("mobile", true);
//		map.put("width", 600);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
				
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/app-root/nav/button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[2]/a")).click();

	}

}
