package CloudBLM.GitHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dimensions {
	
public static WebDriver driver = WebBrowser.driver;
	
	public static void Dimension() throws InterruptedException 
	{
         driver.findElement(By.xpath("//li[@blmtooltip='Dimensions']")).click();
         Thread.sleep(2000);
         
         WebElement Dimensions = driver.findElement(By.xpath("//div[@class='e-content']"));
 	     System.out.println(Dimensions.getText());
}
}