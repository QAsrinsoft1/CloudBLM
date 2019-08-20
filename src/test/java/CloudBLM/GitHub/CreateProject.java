package CloudBLM.GitHub;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProject {
	
	public static WebDriver driver = WebBrowser.driver;
	public static File src;
	public static FileInputStream fis;
	public static HSSFSheet sh1;
	public static HSSFWorkbook wb;
	
	public static void ProjectValidation() throws InterruptedException, AWTException, IOException {
		
	driver.findElement(By.xpath("//a[text()=' Create ']")).click();
	Thread.sleep(2000);
	
	src = new File("D:\\Datasheet\\CloudBLM Model.xls");
	fis = new FileInputStream(src);
	wb = new HSSFWorkbook(fis);
	sh1 = wb.getSheetAt(0);
	System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
	String Name = sh1.getRow(1).getCell(0).getStringCellValue();
	Thread.sleep(2000);
	
	// touch the project name field but not entered the value
			driver.findElement(By.xpath("//*[@id='projectName']")).click();
			Thread.sleep(4000);
			System.out.println("pass");
			driver.findElement(By.xpath("(//*[@class='form-group'])[1]")).click();
			Thread.sleep(2000);
			// Validate the validation message
			String validationmessage = "Project Name is required";
			String text = driver.findElement(By.xpath("//*[text() ='Project Name is required']")).getText();
			System.out.println(text);
			if (validationmessage.contains(text)) {
				System.out.println("validation message are same");
			} else {
				System.out.println("validation message are different");
			}
		}
}
