package NewPackage;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.model.ConnectionType;
import org.openqa.selenium.devtools.v97.network.Network;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools= driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devtools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000,Optional.of( ConnectionType.WIFI)));
		long startTime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("/html/body/app-root/app-landingpage/div/button")).click();
		long stopTime=System.currentTimeMillis();
		
		System.out.println("Start Time="+startTime+" Stop Time"+stopTime+" Difference"+(stopTime-startTime));
	}

}
