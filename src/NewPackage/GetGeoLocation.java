package NewPackage;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class GetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools= driver.getDevTools();
		
		devtools.createSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("latitude", 48);
		map.put("longitude", 2);
		map.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", map);
				
		driver.get("https://google.com");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3")).click();

	}

}
