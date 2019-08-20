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
import org.openqa.selenium.interactions.Actions;

public class Rules {

public static WebDriver driver = WebBrowser.driver;
public static File src;
public static FileInputStream fis;
public static HSSFSheet sh1;
public static HSSFWorkbook wb;
	
	public static void RulesIssues() throws InterruptedException, IOException, AWTException 
	{
         driver.findElement(By.xpath("//a[@id='ManageRule']")).click();
         Thread.sleep(2000);
         
         driver.findElement(By.xpath("//a[text()=' Create ']")).click();
         Thread.sleep(2000);          
         
 		 src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
 		 fis = new FileInputStream(src);
 		 wb = new HSSFWorkbook(fis);
 		 sh1 = wb.getSheetAt(3);
 		 System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
 	 	 String Name = sh1.getRow(1).getCell(0).getStringCellValue();
 		 Thread.sleep(2000);	
         WebElement RuleName = driver.findElement(By.id("rule_name"));
         RuleName.click();
         RuleName.sendKeys(Name);
         RuleName.click();
         Thread.sleep(2000);
         
         System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
 	 	 String Type = sh1.getRow(1).getCell(1).getStringCellValue();
 		 Thread.sleep(2000);	
         WebElement RuleType = driver.findElement(By.id("rule_type_select"));
         RuleType.click();
         RuleType.sendKeys(Type);
         RuleType.click();
         Thread.sleep(2000);
         
         System.out.println(sh1.getRow(1).getCell(2).getStringCellValue());
 	 	 String Severity = sh1.getRow(1).getCell(2).getStringCellValue();
 		 Thread.sleep(2000);	
         WebElement SeverityType = driver.findElement(By.id("rule_severity"));
         SeverityType.click();
         SeverityType.sendKeys(Severity);
         SeverityType.click();
         Thread.sleep(2000);
         
         System.out.println(sh1.getRow(1).getCell(3).getStringCellValue());
 	 	 String Desc = sh1.getRow(1).getCell(3).getStringCellValue();
 		 Thread.sleep(2000);	
         WebElement Description = driver.findElement(By.id("rule_description"));
         Description.click();
         Description.sendKeys(Desc);
         Description.click();
         Thread.sleep(2000);
         
         driver.findElement(By.xpath("//input[@class='btn_create']")).click();
         Thread.sleep(2000);
         
         System.out.println(sh1.getRow(1).getCell(4).getStringCellValue());
 	 	 String cate = sh1.getRow(1).getCell(4).getStringCellValue();
 		 Thread.sleep(2000);	
         WebElement Category = driver.findElement(By.xpath("//div[@class='e-multiselect e-input-group e-checkbox']"));
         Category.click();
         Thread.sleep(2000);
         Actions builder = new Actions(driver);
         builder.sendKeys(cate).perform();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@class='e-checkbox-wrapper e-css']")).click();
         Category.click();
         Thread.sleep(2000);
         
         System.out.println(sh1.getRow(1).getCell(5).getStringCellValue());
 	 	 String Pro = sh1.getRow(1).getCell(5).getStringCellValue();
 		 Thread.sleep(2000);	
         WebElement Property = driver.findElement(By.id("param_type"));
         Property.click();
         Thread.sleep(3000);
         Property.sendKeys(Pro);
         Property.click();
         Thread.sleep(2000);
         
         driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-add-icon']")).click();
         Thread.sleep(2000);
         
         driver.findElement(By.xpath("//li[text()='Add Group']")).click();
         Thread.sleep(2000);
         
         WebElement Search = driver.findElement(By.xpath("//span[@class='e-input-group e-control-wrapper e-ddl e-lib e-keyboard']"));
         Search.click();
         Search.sendKeys("Family Name");
         Search.click();
         Thread.sleep(2000);
         
         WebElement Value = driver.findElement(By.xpath("//span[@class='e-input-group e-control-wrapper e-ddl e-lib e-keyboard']"));
         Value.click();
         Value.sendKeys("Basic Walls");
         Value.click();
         Thread.sleep(2000);
         
         driver.findElement(By.xpath("//button[text()='Create']")).click();
         Thread.sleep(2000);
}
}