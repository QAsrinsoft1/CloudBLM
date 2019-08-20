package CloudBLM.GitHub;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Revit_ProjectSelection {

	public static WiniumDriver driver = Revit_Exporter.driver;
	public static File src;
	public static FileInputStream fis;
	public static HSSFSheet sh1;
	public static HSSFWorkbook wb;
	

	public static void RevitProject() throws InterruptedException, AWTException, FindFailed, IOException {					
		
		driver.findElement(By.id("CustomCtrl_%CustomCtrl_%Cloud BLM%Cloud BLM%Publish Model")).click();
		Thread.sleep(2000);
		
		src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
		fis = new FileInputStream(src);
		wb = new HSSFWorkbook(fis);
		sh1 = wb.getSheetAt(0);
		System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
		String Name = sh1.getRow(1).getCell(0).getStringCellValue();
		Thread.sleep(4000);
				
		WebElement Search = driver.findElement(By.id("searchBox"));
		Search.sendKeys(Name);
		Thread.sleep(4000);
		
		driver.findElement(By.id("Expander")).click();
		Thread.sleep(2000);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();	
		WebElement SubProject = (driver.findElement(By.name(dateFormat.format(date))));
		SubProject.click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("uvpublishbtn")).click();
		Thread.sleep(40000);
		
		WebDriverWait wait = new WebDriverWait(driver, 50000);
		while(wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Close")))==null);
		{
		Thread.sleep(5000);
		}		
    	Thread.sleep(3000);
		driver.findElement(By.id("closebtn")).click();
		Thread.sleep(5000);		
}
}