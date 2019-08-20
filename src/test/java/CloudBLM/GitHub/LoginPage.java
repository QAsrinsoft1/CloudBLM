package CloudBLM.GitHub;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LoginPage {

	public static WebDriver driver = WebBrowser.driver;
	public static File src;
	public static FileInputStream fis;
	public static HSSFSheet sh1;
	public static HSSFWorkbook wb;

	public static void LoginValidation() throws InterruptedException, AWTException, IOException {

		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		Assert.assertEquals("CloudBLM", driver.getTitle());
		Thread.sleep(2000);
	//	src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
	//	fis = new FileInputStream(src);
	//	wb = new HSSFWorkbook(fis);
	//	sh1 = wb.getSheetAt(4);
	//	System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
//		String User = sh1.getRow(1).getCell(0).getStringCellValue();
		Thread.sleep(2000);
	//	System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
	//	String Pass = sh1.getRow(1).getCell(1).getStringCellValue();
		Thread.sleep(2000);


	// invalid UserName and valid Password

		WebElement element = driver.findElement(By.xpath("//*[@id='login-email']"));
		element.sendKeys("qcdsdsd@sst");
		WebElement element1 = driver.findElement(By.id("login-password"));
		element1.sendKeys("sst12345");
		driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
		Thread.sleep(3000);
	

	// valid UserName and invalid Password

		WebElement element2 = driver.findElement(By.xpath("//*[@id='login-email']"));
		element2.sendKeys("             qc@sst.com");
		WebElement element3 = driver.findElement(By.id("login-password"));
		element3.sendKeys("sstfdfsfdsfds12345");
		driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
		Thread.sleep(3000);
	

	// invalid UserName and invalid Password

		driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys("qdsdsc@sst.com");
		driver.findElement(By.id("login-password")).sendKeys("sstfdfsfdsfdsdsdsd12345");
		driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
		Thread.sleep(3000);
	

	// login the application with valid UserName and password

		driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys("qc@sst.com");
		driver.findElement(By.id("login-password")).sendKeys("sst12345");
		driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		String name = "CloudBLM";
		System.out.println(title);
		if (name.equals(title)) {
			System.out.println("title is valid");
		} else {
			System.out.println("title is invalid");
		}
		Thread.sleep(2000);

	   System.out.println("Login Scenarios are validate Successfully");
	   Thread.sleep(2000);
    }
}


	

