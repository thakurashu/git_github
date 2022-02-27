package NewPackage;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devtools= driver.getDevTools();
		
		devtools.createSession();
		
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request->
		{
			if(request.getRequest().getUrl().contains("shetty")) {
				String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=badguy");
				System.out.println(mockedUrl);
				
				devtools.send(Fetch.continueRequest(request.getRequestId(),Optional.of( mockedUrl), Optional.of(request.getRequest().getMethod())
						, Optional.empty(), Optional.empty(), Optional.empty()));
				
			}
		});
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-landingpage/div/button")).click();
		
		
		
	}

}
