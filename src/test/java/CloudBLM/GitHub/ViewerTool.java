package CloudBLM.GitHub;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class ViewerTool {
	
	public static WebDriver driver = WebBrowser.driver;
	
	public static void Tooloption() throws InterruptedException, AWTException, FindFailed
	{
		driver.findElement(By.id("3d-pulse")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("nav-fullScreen")).click();
		Thread.sleep(2000);
	//	Robot press = new Robot();
	//	press.keyPress(KeyEvent.VK_ESCAPE);
	//	press.keyRelease(KeyEvent.VK_ESCAPE);
	//	Thread.sleep(2000);
		driver.findElement(By.id("nav-fullScreen")).click();
		Thread.sleep(2000);
		
		WebElement Clip = driver.findElement(By.id("iconSectionClipping"));
		Clip.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@title='xplane']")).click();
		Thread.sleep(2000);
		Clip.click();
		Thread.sleep(2000);
		Clip.click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("nav-fitToScreen")).click();
		Thread.sleep(2000);
		
		Screen screen = new Screen();
		Pattern Element = new Pattern("D:\\Selenium files\\CloudBLM\\Screenshots\\wall.png");
		screen.click(Element);       
		Thread.sleep(4000);
		
		driver.findElement(By.id("hideByCategory")).click();
		Thread.sleep(2000);
		  
		driver.findElement(By.id("unHide")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("3d-pulse")).click();
		Thread.sleep(2000);
		screen.click(Element);       
		Thread.sleep(4000);
		driver.findElement(By.id("nav-property-window")).click();
		Thread.sleep(2000);
		
		WebElement TypeProperty = driver.findElement(By.xpath("//table[@class='table table-sm']"));
		System.out.println("-----------------------Type Properties-----------------------");
		System.out.println(TypeProperty.getText());
		Thread.sleep(2000);
		
		driver.findElement(By.id("nav-instance-tab")).click();
		Thread.sleep(2000);
		WebElement InstanceProperty = driver.findElement(By.xpath("//div[@id='collapseOne0']"));
		System.out.println("-----------------------Instance Properties-----------------------");
		System.out.println(InstanceProperty.getText());
		Thread.sleep(2000);
		System.out.println("----------------------------------------------");
		
	}

}
