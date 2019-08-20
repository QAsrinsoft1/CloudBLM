package CloudBLM.GitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser {
	
	public static WebDriver driver;
	
	public static void LaunchBrowser() throws InterruptedException {

		    System.setProperty("webdriver.chrome.driver", "D:\\Selenium files\\Jars\\chromedriver.exe");
		    driver = new ChromeDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get("http://192.168.2.14/blm/");
		    Thread.sleep(5000);
	}
}
