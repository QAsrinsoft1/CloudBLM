package CloudBLM.GitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser {
	
	public static WebDriver driver;
	
	public static void LaunchBrowser() throws InterruptedException {

		    System.setProperty("webdriver.chrome.driver", "D:\\Chrome Driver\\chromedriver.exe");
		    driver = new ChromeDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get("http://192.168.1.154/blm/");
		    Thread.sleep(3000);
	}
}
