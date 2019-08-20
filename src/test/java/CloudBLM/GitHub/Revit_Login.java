package CloudBLM.GitHub;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Revit_Login {
	
public static WiniumDriver driver = Revit_Exporter.driver;
public static File src;
public static FileInputStream fis;
public static HSSFSheet sh1;
public static HSSFWorkbook wb;

	public static void Login() throws InterruptedException, AWTException, FindFailed, IOException {		
		
		Screen screen = new Screen();
		Pattern BLM = new Pattern ("D:\\Selenium files\\CloudBLM\\Screenshots\\blm.png");
		screen.click(BLM);
		Thread.sleep(2000);
		driver.findElement(By.id("CustomCtrl_%CustomCtrl_%Cloud BLM%Cloud BLM%Login")).click();
		Thread.sleep(4000);
		if (driver.findElement(By.id("welecometxt")).isDisplayed()) {
			System.out.println("Welcome Back UI is found");
		} else {
			System.out.println("Welcome Back UI is not found");
		}
		Thread.sleep(4000);
		
		src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
		fis = new FileInputStream(src);
		wb = new HSSFWorkbook(fis);
		sh1 = wb.getSheetAt(4);
		System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
		String User = sh1.getRow(1).getCell(0).getStringCellValue();
		Thread.sleep(2000);
		
		WebElement UesrName = driver.findElement(By.id("usernameBox"));
		UesrName.click();
		UesrName.sendKeys(User);
		Thread.sleep(3000);
		
		System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
		String Pass = sh1.getRow(1).getCell(1).getStringCellValue();
		Thread.sleep(2000);
		WebElement Password = driver.findElement(By.id("pswdBox"));
		Password.click();
		Password.sendKeys(Pass);
		Thread.sleep(3000);
		driver.findElement(By.id("LoginBtn")).click();
		Thread.sleep(3000);	
		if (driver.findElement(By.name("You have logged in successfully.")).isDisplayed()) {
			System.out.println("Login Successful UI is found");
		} else {
			System.out.println("Login Successful UI is not found");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("SubmitButton")).click();
		Thread.sleep(2000);
		}
}