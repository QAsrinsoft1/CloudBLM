package CloudBLM.GitHub;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;


public class ModelViewer {
	public static WebDriver driver = WebBrowser.driver;

	public static void Viewer() throws InterruptedException, AWTException, FindFailed {
		
		WebElement ModelCount = driver.findElement(By.xpath("//span[@class='e-badge e-badge-notification e-badge-overlap icon-badge  e-badge-warning']"));
		System.out.println(ModelCount.getText());	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='icon-d-viewer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='e-icons e-treegridexpand']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='e-headercelldiv']//div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View']")).click();
	
		WebElement ProgressBar = driver.findElement(By.xpath("//div[@class='progress']"));
		while (true) {
			try {
				if (ProgressBar.isDisplayed())
					System.out.println("Progress is displayed");
				// return;
			} catch (Exception e) {
				System.out.println("Progress is not displayed");
				return;
			}
		}
	}
	}
	
	

