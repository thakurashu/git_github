package NewPackage;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools= driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.setBlockedURLs(ImmutableList.of("*.css","*.jpg")));
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("/html/body/app-root/nav/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-product-details/div/div[2]/div/ul/div[1]/li/div/div/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-product-shop/body/div[2]/div/div/div[2]/div[2]/button[1]")).click();

	}

}
