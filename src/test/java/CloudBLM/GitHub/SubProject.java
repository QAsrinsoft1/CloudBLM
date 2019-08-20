package CloudBLM.GitHub;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubProject {
	
	public static WebDriver driver = WebBrowser.driver;
	public static File src;
	public static FileInputStream fis;
	public static HSSFSheet sh1;
	public static HSSFWorkbook wb;
	
	public static void SubProjectCreation() throws InterruptedException, AWTException, IOException 
	{
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
		
		driver.findElement(By.xpath("//span[@id='icon_3']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[@blmtooltip='Create']")).click();
		Thread.sleep(2000);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();	
		WebElement SubProject = (driver.findElement(By.id("projectName")));
		SubProject.click();
		SubProject.sendKeys(dateFormat.format(date));
		Thread.sleep(2000);
		
		WebElement Description = (driver.findElement(By.id("Description")));
		Description.click();
		Description.sendKeys("Test Description for Sub Project");
		Thread.sleep(2000);
		
	//	driver.findElement(By.xpath("//span[text()='Create']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Back to Projects']")).click();
		Thread.sleep(2000);		
}
}


