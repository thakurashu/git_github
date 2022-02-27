package NewPackage;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashut\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Predicate<URI>uripre= uri->uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uripre,UsernameAndPassword.of("foo", "bar"));
		
		driver.get("https://httpbin.org/basic-auth/foo/bar");
	}

}
