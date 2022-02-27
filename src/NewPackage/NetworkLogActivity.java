package NewPackage;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.openqa.selenium.devtools.v97.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools= driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devtools.addListener(Network.requestWillBeSent(), request->
		{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
			System.out.println(req.getHeaders());
			
		});
		
		devtools.addListener(Network.responseReceived(), response->
		{
			Response res = response.getResponse();
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
			
		}
				);
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("/html/body/app-root/app-landingpage/div/button")).click();
	}

}
