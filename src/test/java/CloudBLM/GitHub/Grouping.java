package CloudBLM.GitHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Grouping {
	
	public static WebDriver driver = WebBrowser.driver;
	
	public static void Group() throws InterruptedException 
	{        
		 driver.findElement(By.id("ModelViewer")).click();
		 Thread.sleep(2000);
		   
		 driver.findElement(By.xpath("//div[@class='e-headercelldiv']//div")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[text()='View']")).click();
		   
		 WebElement ProgressBar = driver.findElement(By.xpath("//div[@class='progress']"));
		 while (true) {
			try {
					if (ProgressBar.isDisplayed())
						System.out.println("Progress is displayed");
				} catch (Exception e) {
					System.out.println("Progress is not displayed");
					return;
				}
		
		driver.findElement(By.xpath("//a[@id='navGrouping']")).click();
		Thread.sleep(2000);
		
	//	WebElement Group = driver.findElement(By.xpath("//div[@class='control-section']"));
		WebElement Group = driver.findElement(By.xpath("//table[@class=\"e-table\"]"));
		System.out.println(Group.getText());
			
		driver.findElement(By.xpath("//span[text()='Walls']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@id='color-picker-wrapper_3']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@title='Apply']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[text()='Reset']")).click();
		Thread.sleep(2000);
		
		String str = Group.getText();        
        if(str.contains("Walls")) {  
            System.out.println("This string contains Walls");  
        }else  
            System.out.println("Result not found"); 
    }  		 	 
}
}	
