package CloudBLM.GitHub;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class SearchProject {
	
public static WebDriver driver = WebBrowser.driver;
public static File src;
public static FileInputStream fis;
public static HSSFSheet sh1;
public static HSSFWorkbook wb;
	
	public static void ProjectSelection() throws InterruptedException, AWTException, IOException, FindFailed
	{
		Screen screen = new Screen();
		Pattern Chrome = new Pattern("D:\\Selenium files\\CloudBLM\\Screenshots\\chrome.png");
		screen.click(Chrome);
		Thread.sleep(3000);	
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='filter-enable pointer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Project Type']")).click();
		Thread.sleep(2000);
		
		for(int i=0; i<5; i++)
		{
			Robot Press = new Robot();
			Press.keyPress(KeyEvent.VK_TAB);
			Press.keyRelease(KeyEvent.VK_TAB);
		}
		Thread.sleep(2000);
		WebElement Search = driver.findElement(By.xpath("//div[@class='fs-input-control']//input[@class='ng-pristine ng-valid ng-touched']"));
		Search.click();
		Thread.sleep(2000);
		src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
		fis = new FileInputStream(src);
		wb = new HSSFWorkbook(fis);
		sh1 = wb.getSheetAt(0);
		System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
		String Name = sh1.getRow(1).getCell(0).getStringCellValue();
		Thread.sleep(2000);
		Search.sendKeys(Name);
		Thread.sleep(2000);
		
		WebElement ProjectTitle = driver.findElement(By.xpath("//h2[@class='card-item-title']"));	
		System.out.println(ProjectTitle.getText());	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-bars']")).click();
		Thread.sleep(2000);
		String strr = ProjectTitle.getText();
		Assert.assertEquals(strr, Name);
		if(strr.startsWith(Name))
		{
		 System.out.println("Pass");
		}
		else
		{
		System.out.println("Fail");
		}
		
		driver.findElement(By.xpath("//span[@id='icon_3']")).click();
		Thread.sleep(2000);
	}

}
