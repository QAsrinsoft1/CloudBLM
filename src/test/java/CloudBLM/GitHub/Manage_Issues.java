package CloudBLM.GitHub;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class Manage_Issues {

	public static WebDriver driver = WebBrowser.driver;
	public static File src;
	public static FileInputStream fis;
	public static HSSFSheet sh1;
	public static HSSFWorkbook wb;

	public static void IssuesValidation() throws InterruptedException, AWTException, FindFailed, IOException {
		
		src = new File("D:\\Selenium files\\CloudBLM\\CloudBLM Model.xls");
		fis = new FileInputStream(src);
		wb = new HSSFWorkbook(fis);
		sh1 = wb.getSheetAt(1);
		
		WebElement element = driver.findElement(By.xpath("//i[@class='icon-issue-c text-danger instanceHover pointer float-right']"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		
		System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
		String Name = sh1.getRow(1).getCell(0).getStringCellValue();
		Thread.sleep(2000);	
		WebElement IssueName = driver.findElement(By.xpath("//input[@type='text']"));
		IssueName.click();
		IssueName.sendKeys(Name);
		Thread.sleep(2000);

    //  Property Based Issue
		
		if (driver.findElement(By.xpath("//option[text()='Property Based Issue']")).isSelected()) 
		{
			System.out.println("Issue Type is in Selected");
		} else {
			System.out.println("Issue Type is in Not Selected");
		//	Assert.fail();
		}
		Thread.sleep(2000);
			
		System.out.println(sh1.getRow(1).getCell(2).getStringCellValue());
		String Assignee = sh1.getRow(1).getCell(2).getStringCellValue();
		Thread.sleep(2000); 
		WebElement AssigneeName = driver.findElement(By.xpath("//select[@formcontrolname='AssignedTo']"));
		AssigneeName.click();
		AssigneeName.sendKeys(Assignee);
		AssigneeName.click();
	    Thread.sleep(2000);
	    
	    System.out.println(sh1.getRow(1).getCell(3).getStringCellValue());
		String SeverityType = sh1.getRow(1).getCell(3).getStringCellValue();
		Thread.sleep(2000);	    
	    WebElement Severity = driver.findElement(By.xpath("//select[@formcontrolname='IssueSeverity']"));
		Severity.click();
		Severity.sendKeys(SeverityType);
		Severity.click();
		Thread.sleep(2000);
		
		System.out.println(sh1.getRow(1).getCell(4).getStringCellValue());
		String StatusType = sh1.getRow(1).getCell(4).getStringCellValue();
		Thread.sleep(2000);    
		WebElement Status = driver.findElement(By.xpath("//select[@formcontrolname='IssueStatus']"));
		Status.click();
		Status.sendKeys(StatusType);
		Status.click();
		Thread.sleep(2000);
		
		System.out.println(sh1.getRow(1).getCell(5).getStringCellValue());
		String Description = sh1.getRow(1).getCell(5).getStringCellValue();
		Thread.sleep(2000);
		WebElement Desc = driver.findElement(By.id("description"));
		Desc.click();
		Desc.sendKeys(Description);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Create']")).click();
		
	//	driver.findElement(By.xpath("//input[@value='Cancel']")).click();
        Thread.sleep(2000);
        	
		driver.findElement(By.xpath("//a[@id='ManageIssues']")).click();
		Thread.sleep(2000);
		
	//	WebElement SearchIssue = driver.findElement(By.xpath("//div[@class='row custCardItem']"));
	//	System.out.println(SearchIssue.getText());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='PROPERTY BASED ...']")).click();  
        Thread.sleep(2000);
        
    //  WebElement PropertyIssue = driver.findElement(By.xpath("//h5[text()='Property Based Issue']"));
	//	System.out.println(PropertyIssue.getText());
		Thread.sleep(2000);
		       
	   driver.findElement(By.xpath("//span[text()='Cancel']")).click();
	   Thread.sleep(2000);
	   
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
			
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//span[@class='icon-issue']")).click();
	   Thread.sleep(4000);
	   
		Screen screen = new Screen();
		Pattern Element = new Pattern("D:\\Selenium files\\CloudBLM\\Screenshots\\wall.png");
		screen.click(Element);       
		Thread.sleep(4000);
	   
	   driver.findElement(By.xpath("//button[@title='Create Issue']")).click();
	   Thread.sleep(2000);   
	 
	    System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
		String Name1 = sh1.getRow(2).getCell(0).getStringCellValue();
		Thread.sleep(2000);	
		WebElement IssueName1 = driver.findElement(By.xpath("//input[@type='text']"));
		IssueName1.click();
		IssueName1.sendKeys(Name1);
		Thread.sleep(2000);

	// Element Based Issue
		
			if (driver.findElement(By.xpath("//option[text()='Element Based Issue']")).isSelected()) 
			{
				System.out.println("Issue Type is in Selected");
			} else {
				System.out.println("Issue Type is in Not Selected");
			//	Assert.fail();
			}
			Thread.sleep(2000);
				
			System.out.println(sh1.getRow(2).getCell(2).getStringCellValue());
			String Assignee1 = sh1.getRow(2).getCell(2).getStringCellValue();
			Thread.sleep(2000); 
			WebElement AssigneeName1 = driver.findElement(By.xpath("//select[@formcontrolname='AssignedTo']"));
			AssigneeName1.click();
			AssigneeName1.sendKeys(Assignee1);
			AssigneeName1.click();
		    Thread.sleep(2000);
		    
		    System.out.println(sh1.getRow(2).getCell(3).getStringCellValue());
			String SeverityType1 = sh1.getRow(2).getCell(3).getStringCellValue();
			Thread.sleep(2000);	    
		    WebElement Severity1 = driver.findElement(By.xpath("//select[@formcontrolname='IssueSeverity']"));
			Severity1.click();
			Severity1.sendKeys(SeverityType1);
			Severity1.click();
			Thread.sleep(2000);
			
			System.out.println(sh1.getRow(2).getCell(4).getStringCellValue());
			String StatusType1 = sh1.getRow(2).getCell(4).getStringCellValue();
			Thread.sleep(2000);    
			WebElement Status1 = driver.findElement(By.xpath("//select[@formcontrolname='IssueStatus']"));
			Status1.click();
			Status1.sendKeys(StatusType1);
			Status1.click();
			Thread.sleep(2000);
			
			System.out.println(sh1.getRow(1).getCell(5).getStringCellValue());
			String Description1 = sh1.getRow(1).getCell(5).getStringCellValue();
			Thread.sleep(2000);
			WebElement Desc1 = driver.findElement(By.id("description"));
			Desc1.click();
			Desc1.sendKeys(Description1);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@value='Create']")).click();
			
		//	driver.findElement(By.xpath("//input[@value='Cancel']")).click();
	        Thread.sleep(2000);
	        	
			driver.findElement(By.xpath("//a[@id='ManageIssues']")).click();
			Thread.sleep(2000);
			
	//		WebElement SearchIssue1 = driver.findElement(By.xpath("//div[@class='row custCardItem']"));
	//		System.out.println(SearchIssue1.getText());
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[text()='ELEMENT BASED I...']")).click();  
	        Thread.sleep(2000);
	        
	        WebElement ElementIssue = driver.findElement(By.xpath("//h5[text()='Element Based Issue']"));
			System.out.println(ElementIssue.getText());
			Thread.sleep(2000);
			       
		   driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		   Thread.sleep(2000);
		   
		   driver.findElement(By.id("ModelViewer")).click();
		   Thread.sleep(2000);
		   
		   driver.findElement(By.xpath("//div[@class='e-headercelldiv']//div")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//button[text()='View']")).click();
		   
		   WebElement ProgressBar1 = driver.findElement(By.xpath("//div[@class='progress']"));
			while (true) {
				try {
					if (ProgressBar1.isDisplayed())
						System.out.println("Progress is displayed");
				} catch (Exception e) {
					System.out.println("Progress is not displayed");
					return;
				}
		   
		   driver.findElement(By.id("navIssues")).click();
		   Thread.sleep(2000);
		   
		   driver.findElement(By.xpath("//button[@title='Create Issue']")).click();
		   Thread.sleep(2000);   
		 
		    System.out.println(sh1.getRow(3).getCell(0).getStringCellValue());
			String Name2 = sh1.getRow(3).getCell(0).getStringCellValue();
			Thread.sleep(2000);	
			WebElement IssueName2 = driver.findElement(By.xpath("//input[@type='text']"));
			IssueName2.click();
			IssueName2.sendKeys(Name2);
			Thread.sleep(2000);
		
		
   //  Standalone Issue
		
		if (driver.findElement(By.xpath("//option[text()='Standalone']")).isSelected()) 
		{
			System.out.println("Issue Type is in Selected");
		} else {
			System.out.println("Issue Type is in Not Selected");
		//	Assert.fail();
		}
		Thread.sleep(2000);

	/*	System.out.println(sh1.getRow(3).getCell(1).getStringCellValue());
		String Reporter = sh1.getRow(3).getCell(1).getStringCellValue();
		Thread.sleep(2000); 
		WebElement ReporterName = driver.findElement(By.xpath("//select[@formcontrolname='reporter']"));
		ReporterName.click();
	    ReporterName.sendKeys(Reporter);
	    ReporterName.click();
	    Thread.sleep(2000);*/
		
		System.out.println(sh1.getRow(3).getCell(2).getStringCellValue());
		String Assignee2 = sh1.getRow(3).getCell(2).getStringCellValue();
		Thread.sleep(2000); 
		WebElement AssigneeName2 = driver.findElement(By.xpath("//select[@formcontrolname='AssignedTo']"));
		AssigneeName2.click();
		AssigneeName2.sendKeys(Assignee2);
		AssigneeName2.click();
	    Thread.sleep(2000);
	    
	    System.out.println(sh1.getRow(3).getCell(3).getStringCellValue());
		String SeverityType2 = sh1.getRow(3).getCell(3).getStringCellValue();
		Thread.sleep(2000);	    
	    WebElement Severity2 = driver.findElement(By.xpath("//select[@formcontrolname='IssueSeverity']"));
		Severity2.click();
		Severity2.sendKeys(SeverityType2);
		Severity2.click();
		Thread.sleep(2000);
		
		System.out.println(sh1.getRow(3).getCell(4).getStringCellValue());
		String StatusType2 = sh1.getRow(3).getCell(4).getStringCellValue();
		Thread.sleep(2000);    
		WebElement Status2 = driver.findElement(By.xpath("//select[@formcontrolname='IssueStatus']"));
		Status2.click();
		Status2.sendKeys(StatusType2);
		Status2.click();
		Thread.sleep(2000);
		
		System.out.println(sh1.getRow(3).getCell(5).getStringCellValue());
		String Description2 = sh1.getRow(3).getCell(5).getStringCellValue();
		Thread.sleep(2000);
		WebElement Desc2 = driver.findElement(By.id("description"));
		Desc2.click();
		Desc2.sendKeys(Description2);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Create']")).click();
		
	 //	driver.findElement(By.xpath("//input[@value='Cancel']")).click();
        Thread.sleep(2000);
       	
		driver.findElement(By.xpath("//a[@id='ManageIssues']")).click();
		Thread.sleep(2000);
		
		WebElement SearchIssues = driver.findElement(By.xpath("//h2[@class='card-item-title']"));
		System.out.println(SearchIssues.getText());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='STANDALONE ISSU...']")).click();  
        Thread.sleep(2000);
       
        WebElement StandaloneIssue = driver.findElement(By.xpath("//h5[text()='Standalone']"));
		System.out.println(StandaloneIssue.getText());
		Thread.sleep(2000);
		       
	   driver.findElement(By.xpath("//span[text()='Cancel']")).click();
	   Thread.sleep(2000);
		
	}
}
	}
	}
