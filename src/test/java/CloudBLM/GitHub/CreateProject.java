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

public class CreateProject {
	
	public static WebDriver driver = WebBrowser.driver;
	public static File src;
	public static FileInputStream fis;
	public static HSSFSheet sh1;
	public static HSSFWorkbook wb;
	
	public static void ProjectValidation() throws InterruptedException, AWTException, IOException {
		
	driver.findElement(By.xpath("//a[text()=' Create ']")).click();
	Thread.sleep(2000);
	
	src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
	fis = new FileInputStream(src);
	wb = new HSSFWorkbook(fis);
	sh1 = wb.getSheetAt(0);
	System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
	String Name = sh1.getRow(1).getCell(0).getStringCellValue();
	Thread.sleep(2000);
	
	driver.findElement(By.id("projectName")).sendKeys(Name);
	Thread.sleep(2000);
	
	System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
	String Type = sh1.getRow(1).getCell(1).getStringCellValue();
	Thread.sleep(2000);
	WebElement ProjectType = (driver.findElement(By.xpath("//select[@formcontrolname='ProjectTypeID']")));
	ProjectType.click();
	ProjectType.sendKeys(Type);
	ProjectType.click();
	
	System.out.println(sh1.getRow(1).getCell(2).getStringCellValue());
	String Construction = sh1.getRow(1).getCell(2).getStringCellValue();
	Thread.sleep(2000);
	WebElement ConstructionType = (driver.findElement(By.xpath("//select[@formcontrolname='ConstructionTypeID']")));
	ConstructionType.click();
	ConstructionType.sendKeys(Construction);
	ConstructionType.click();
	
	System.out.println(sh1.getRow(1).getCell(3).getStringCellValue());
	String Contract = sh1.getRow(1).getCell(3).getStringCellValue();
	Thread.sleep(2000);
	WebElement ContractType = (driver.findElement(By.xpath("//select[@formcontrolname='ContractTypeID']")));
	ContractType.click();
	ContractType.sendKeys(Contract);
	ContractType.click();

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	
	WebElement StartDate = driver.findElement(By.xpath("//input[@placeholder='Select a start date']"));
	StartDate.click();
	StartDate.sendKeys(dateFormat.format(date));
	Thread.sleep(2000);
	
	SimpleDateFormat Start = new SimpleDateFormat("MM/dd/yyyy");
    SimpleDateFormat End = new SimpleDateFormat("MM/dd/yyyy");
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());    
    System.out.println(Start.format(calendar.getTime()));
    calendar.add(Calendar.DATE,-6);
    System.out.println(End.format(calendar.getTime()));	
	
 //   StartDate.sendKeys(sdf1.format(calendar.getTime()));   
    
	WebElement EndDate = driver.findElement(By.xpath("//input[@placeholder='Select a end date']"));
	EndDate.click();
	EndDate.sendKeys(End.format(calendar.getTime()));
	Thread.sleep(2000);	
	System.out.println(End.format(calendar.getTime()));
	
	System.out.println(sh1.getRow(1).getCell(4).getStringCellValue());
	String Description = sh1.getRow(1).getCell(4).getStringCellValue();
	Thread.sleep(2000);
	driver.findElement(By.id("Description")).sendKeys(Description);
	Thread.sleep(2000);
	
	if(driver.findElement(By.xpath("//div[text()=' End date must be greater than Start date ']")).isDisplayed())
	{
		System.out.println("Validation Message is shown");
	}else
	{
		System.out.println("Validation Message is not shown");
		Assert.fail();
	}
	calendar.add(Calendar.DATE,12);
    System.out.println(End.format(calendar.getTime()));		
    EndDate.clear();
    Thread.sleep(2000);
    EndDate.sendKeys(End.format(calendar.getTime()));
	Thread.sleep(2000);
	driver.findElement(By.id("Description")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//span[text()='Cancel']")).click();
//	Thread.sleep(2000);
	
//	driver.findElement(By.xpath("//span[text()='Create']")).click();
	Thread.sleep(2000);
}
}