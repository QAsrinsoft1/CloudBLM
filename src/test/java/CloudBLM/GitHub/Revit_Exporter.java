package CloudBLM.GitHub;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Revit_Exporter {
	
public static WiniumDriver driver;
public static File src;
public static FileInputStream fis;
public static HSSFSheet sh1;
public static HSSFWorkbook wb;
	
	public static void Revit() throws InterruptedException, FindFailed, AWTException, IOException {
	
	DesktopOptions option = new DesktopOptions();
	option.setApplicationPath("C:\\Program Files\\Autodesk\\Revit 2018\\Revit.exe");
	driver = new WiniumDriver(new URL("http://localhost:9999"), option);
	Thread.sleep(5000);
	Screen screen = new Screen();
	Pattern Revit = new Pattern("D:\\Selenium files\\Disney\\Revit Exporter\\revit2018.png");
	screen.click(Revit);
	Thread.sleep(15000);
	Robot press = new Robot();
	press.keyPress(KeyEvent.VK_WINDOWS);
	press.keyPress(KeyEvent.VK_UP);
	press.keyRelease(KeyEvent.VK_WINDOWS);
	press.keyRelease(KeyEvent.VK_UP);
	Thread.sleep(5000);	
	driver.findElement(By.name("File")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("\rNew\r")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("OK")).click();
	Thread.sleep(10000);
	press.keyPress(KeyEvent.VK_Z);
	press.keyPress(KeyEvent.VK_E);
	press.keyRelease(KeyEvent.VK_Z);
	press.keyRelease(KeyEvent.VK_E);		
	Thread.sleep(2000);
	driver.findElement(By.name("Wall")).click();
	Thread.sleep(4000);
//	driver.findElement(By.id("SketchGalleryItem_ID_WALL_POLY_INSCRIBED")).click();
	Pattern Polygon = new Pattern("D:\\Selenium files\\Disney\\Revit Exporter\\polygon.png");
	screen.click(Polygon);
	Thread.sleep(3000);
	Pattern Pane = new Pattern("D:\\Selenium files\\Disney\\Revit Exporter\\pane.png");
	screen.click(Pane);
//	driver.findElement(By.className("AfxFrameOrView140u")).click();
	Thread.sleep(3000);
	screen.type("30");
    press.keyPress(KeyEvent.VK_ENTER);
    press.keyRelease(KeyEvent.VK_ENTER);
    press.keyPress(KeyEvent.VK_M);
	press.keyPress(KeyEvent.VK_D);
	press.keyRelease(KeyEvent.VK_M);
	press.keyRelease(KeyEvent.VK_D);		
	Thread.sleep(2000);
    driver.findElement(By.id("ID_VIEW_DEFAULT_3DVIEW_RibbonItemControl")).click();
	driver.findElement(By.id("ID_Save")).click();
	Thread.sleep(2000);
	WebElement FileName = driver.findElement(By.name("File name:"));
	FileName.click();
	press.keyPress(KeyEvent.VK_CONTROL);
	press.keyPress(KeyEvent.VK_A);
	press.keyRelease(KeyEvent.VK_CONTROL);
	press.keyRelease(KeyEvent.VK_A);
	Thread.sleep(2000);
	press.keyPress(KeyEvent.VK_DELETE);
	press.keyRelease(KeyEvent.VK_DELETE);
	Thread.sleep(2000);
	
	src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
	fis = new FileInputStream(src);
	wb = new HSSFWorkbook(fis);
	sh1 = wb.getSheetAt(2);
	System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
	String val = sh1.getRow(1).getCell(0).getStringCellValue();
	Thread.sleep(4000);
	
	FileName.sendKeys("D:\\Selenium files\\CloudBLM\\Models\\"+val);
	Thread.sleep(2000);
	driver.findElement(By.name("Save")).click();
	Thread.sleep(8000);
	driver.findElement(By.id("1")).click();
	Thread.sleep(8000);
	driver.findElement(By.id("ID_VIEW_DEFAULT_3DVIEW_RibbonItemControl")).click();
	Thread.sleep(4000);
}
}
