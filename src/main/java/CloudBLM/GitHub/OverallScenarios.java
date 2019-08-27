package CloudBLM.GitHub;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class OverallScenarios {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"Z:\\git\\CloudBLM2\\Jar Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Login the application URL

		driver.get("http://192.168.2.14/blm/projects");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys("qc@sst.com");
		driver.findElement(By.id("login-password")).sendKeys("sst12345");
		driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
		Thread.sleep(2000);

		// Create the project name

		driver.findElement(By.xpath("//*[text() =' Create ']")).click();
		System.out.println("pass");

		// Without entered the project name
		driver.findElement(By.xpath("//*[@id='projectName']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@formcontrolname='ProjectTypeID']")).click();
		Thread.sleep(2000);
		/*
		 * driver.findElement(By.xpath("//*[@id='projectName']")).click();
		 * Thread.sleep(4000);
		 * driver.findElement(By.xpath("(//*[@class='form-group'])[1]")).click();
		 * Thread.sleep(2000);
		 */

		// Validate the validation message

		String validationmessage = "Project Name is required";
		String Validusername = driver.findElement(By.xpath("//*[text() ='Project Name is required']")).getText();
		System.out.println(Validusername);
		if (validationmessage.contains(Validusername)) {
			System.out.println("projectname validation message are same");
		} else {
			System.out.println("projectname validation message are different");
		}

		// Enter the inValid userName and validate the validation message

		WebElement Projectname = driver.findElement(By.xpath("//*[@id='projectName']"));
		Projectname.sendKeys("fdsjhfvjhdsvjvgjdhjgfdshfgvjhfdgvjd");
		driver.findElement(By.xpath("//*[@formcontrolname='ProjectTypeID']")).click();
		String Invalidname = "Project Name allowed 16 characters only";
		String projectnamevalidationmessage = driver
				.findElement(By.xpath("//*[text() = 'Project Name allowed 16 characters only.']")).getText();
		if (Invalidname.equals(projectnamevalidationmessage)) {
			System.out.println(" projectname validation message are same");
		} else {
			System.out.println("projectname valisation message are different");
		}
		Projectname.clear();
		Thread.sleep(4000);

		// Enter the Valid userName and validate 

		driver.findElement(By.xpath("//*[@id='projectName']")).sendKeys("Automation Project");
		Thread.sleep(2000);

		// click the project type field and Select the respective project sub type

		driver.findElement(By.xpath("//*[@formcontrolname='ProjectTypeID']")).click();
		Thread.sleep(2000);
		WebElement projectid = driver.findElement(By.xpath("//*[@formcontrolname='ProjectTypeID']"));
		Select sl = new Select(projectid);
		sl.selectByIndex(7);
		String text2 = projectid.getText();
		{
			System.out.println(text2);
		}
		Thread.sleep(2000);

		// click the project sub type field and Select the respective project sub type

		driver.findElement(By.xpath("//*[@formcontrolname ='ProjectSubTypeID']")).click();
		WebElement projectsubtype = driver.findElement(By.xpath("//*[@formcontrolname='ProjectSubTypeID']"));
		Select sel = new Select(projectsubtype);
		sel.selectByIndex(0);
		String text3 = projectsubtype.getText();
		{
			System.out.println(text3);
		}
		Thread.sleep(2000);

		// Validate the Life cycle template and select the value

		driver.findElement(By.xpath("//*[@formcontrolname='LifecycleTemplate']")).click();
		WebElement lifecycletemplate = driver.findElement(By.xpath("//*[@formcontrolname='LifecycleTemplate']"));
		Select sel1 = new Select(lifecycletemplate);
		sel1.selectByIndex(1);
		Thread.sleep(5000);
		String text4 = lifecycletemplate.getText();
		{
			System.out.println(text4);
		}

		// Validate the Construction type and select the value
		driver.findElement(By.xpath("//*[@formcontrolname='ConstructionTypeID']")).click();
		WebElement Construction = driver.findElement(By.xpath("//*[@formcontrolname='ConstructionTypeID']"));
		Select sel4 = new Select(Construction);
		sel4.selectByIndex(1);
		String text6 = Construction.getText();
		{
			System.out.println(text6);
		}
		Thread.sleep(2000);

		// Validate the contract type and select the value

		driver.findElement(By.xpath("//*[@formcontrolname='ContractTypeID']")).click();
		WebElement contract = driver.findElement(By.xpath("//*[@formcontrolname='ContractTypeID']"));

		Select sel5 = new Select(contract);
		sel5.selectByIndex(1);
		String text7 = contract.getText();
		{
			System.out.println(text7);
		}
		Thread.sleep(2000);

		// Validate the start date and validate the validation message

		driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]")).click();
		String startvalid = "Start date is required";
		String dates = driver.findElement(By.xpath("//*[text() =' Start date is required']")).getText();
		if (dates.equals(startvalid)) {
			System.out.println("startdate both validations are same");
		} else {
			System.out.println("startdate Both validations are different");
		}
		Thread.sleep(2000);

		// Validate the start date and enter the value

		driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[1]")).sendKeys("08-08-2019");
		Thread.sleep(2000);

		// Validate the End date and not select the value

		driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[1]")).click();
		String Enddate = "Start date is required";
		String end = driver.findElement(By.xpath("//*[text() =' End date is required']")).getText();
		if (Enddate.equals(end)) {
			System.out.println("Enddate Both validations are same");
		} else {
			System.out.println("Enddate Both validations are different");
		}
		Thread.sleep(2000);

		// Validate the validation message in end date

		WebElement validenddate = driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]"));
		validenddate.sendKeys("08-08-2011");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@formcontrolname ='ProjectAddress']")).click();
		String greatherdate = "End date must be greater than Start date";
		String validmessage = driver.findElement(By.xpath("//*[text() = ' End date must be greater than Start date ']"))
				.getText();
		if (greatherdate.equals(validmessage)) {
			System.out.println("Enddate both validations are same");

		} else {
			System.out.println("Enddate Both validations are different");
		}
		Thread.sleep(2000);
		validenddate.clear();

		// Validate the End date and enter the Value

		driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]")).sendKeys("08-08-2020");
		Thread.sleep(2000);

		// Enter the valid data in project Address field

		driver.findElement(By.xpath("//*[@formcontrolname ='ProjectAddress']"))
				.sendKeys("Bear Hill St., North Ring Road, CA-028 001");
		Thread.sleep(2000);

		// Validate the description field but not enter the value

		driver.findElement(By.id("Description")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		String description2 = "Description is required";
		String description = driver.findElement(By.xpath("//*[text()='Description is required']")).getText();
		if (description.equals(description2)) {
			System.out.println("description Both validations are same");
		} else {
			System.out.println("description Both validations are different");
		}
		driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[1]")).click();
		Thread.sleep(2000);

		// Validate the description field and the enter the value

		driver.findElement(By.id("Description")).sendKeys("Test Description to the Project");
		Thread.sleep(2000);

		// clear the project

		driver.findElement(By.xpath("(//*[@class ='btn btn-secondary'])[2]")).click();
		Thread.sleep(2000);
		// cancel the project
		driver.findElement(By.xpath("(//*[@class ='btn btn-secondary'])[1]")).click();

		// it should display the List of projects
		Thread.sleep(2000);
		List<WebElement> listofprojects = driver.findElements(By.xpath("//*[@class ='card-item-title']"));
		int ssq = listofprojects.size();
		for (int i = 0; i < ssq; i++) {

			String projects = listofprojects.get(i).getText();
			System.err.println(projects);
		}
		System.out.println(ssq);

		// click the Cardview button
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class = 'dropdown-nav dropdown-toggle add-project'])[3]")).click();

		// click the grid view button and get the size and name of the project
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		Thread.sleep(2000);
		List<WebElement> size = driver
				.findElements(By.xpath("//*[@aria-label=' is template cell column header Project Name']"));
		int ss = size.size();
		System.out.println(ss);
		for (int i = 0; i < ss; i++) {
			String projecttitle = size.get(i).getText();
			System.out.println(projecttitle);

		}
		// driver.navigate().back();
		Thread.sleep(4000);
		System.out.println("naviages");
		driver.findElement(By.xpath("//*[@class='fa fa-th-large fa-fw']")).click();
		System.out.println("navigated");
		Thread.sleep(2000);
		// click the side bar filter and search the respective project name
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class = 'filter-enable pointer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@type = 'text'])[2]")).sendKeys("AUTOMATIONTEST");
		Thread.sleep(2000);
		Thread.sleep(2000);
		String test = "AUTOMATIONTEST";
		WebElement sidebar = driver.findElement(By.xpath("//*[text() ='AUTOMATIONTEST']"));
		String projectname = sidebar.getText();
		if (test.equals(projectname)) {
			System.out.println("Both names are matched");
		} else {
			System.out.println("both names are not matched");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Clear All Filters']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class = 'fa fa-bars']")).click();
		// check the project name is displayed or not in cardview
		Thread.sleep(5000);
		WebElement Projectdisplayeadcard = driver.findElement(By.xpath("//*[text()='AUTOMATIONTEST']"));
		String projectname2 = "SffffSS";
		if (Projectdisplayeadcard.isDisplayed()) {
			String projectname3 = Projectdisplayeadcard.getText();
			if (projectname2.equals(projectname3)) {
				System.out.println("elemnts are same");
			} else {
				System.out.println("elements are not same");
			}
			System.out.println(projectname3);
			System.out.println("Project name is displayed");
			Thread.sleep(2000);
		}
		// check the project type is displayed or not in card view
		Thread.sleep(5000);
		WebElement projecttypecard = driver.findElement(By.xpath("//*[text()='Healthcare']"));
		String projecttypename = "Healthcare";
		String projecttypenametext = projecttypecard.getText();
		System.out.println(projecttypenametext);
		if (projecttypecard.isDisplayed()) {
			System.out.println("checkproject type is displayed");
			if (projecttypename.equals(projecttypenametext)) {
				System.out.println("elements are same");
			} else {
				System.out.println("elements are not same ");
			}
		} else {
			System.out.println("checkprojetc type is not displayed");
		}
		Thread.sleep(2000);

		// check the project type is displayed or not
		Thread.sleep(5000);
		WebElement projectsubtypecard = driver.findElement(By.xpath("//*[text()='Hospital']"));
		String projectsubtypename = "Hospital";
		String projectsubtypetext = projectsubtypecard.getText();
		System.out.println(projectsubtypetext);
		if (projectsubtypecard.isDisplayed()) {
			System.out.println("checkprojectsub type is displayed");
			if (projectsubtypename.equals(projectsubtypetext)) {
				System.out.println("elements are same");
			} else {
				System.out.println("elements are not same ");
			}
		} else {
			System.out.println("checkprojetc subtypetype is not displayed");

		}

		// check the Construction type is displayed or not
		Thread.sleep(5000);
		WebElement Constructiontype = driver.findElement(By.xpath("//*[text()='New']"));
		String Constructiontypename = "Renovation";
		String Constructiontypenametext = Constructiontype.getText();
		System.out.println(Constructiontypenametext);
		if (Constructiontype.isDisplayed()) {
			System.out.println("Constructiontype type is displayed");
			if (Constructiontypename.equals(Constructiontypenametext)) {
				System.out.println("elements are same");
			} else {
				System.out.println("elements are not same ");
			}
		} else {
			System.out.println("Constructiontype is not displayed");
		}

		// click the rules icon in card view

		Thread.sleep(3000);
		System.out.println("elment is not cliclkable");
		driver.findElement(By.xpath("//*[@id='icon_1']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		// click the issues icon
		Thread.sleep(5000);
		System.out.println("passed issues");
		driver.findElement(By.xpath("(//*[@class='icon-issue'])[1]")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		// Click the sub folder

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='icon_4']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		System.out.println("passed subfolder");
		Thread.sleep(2000);
		// click the viewer

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='icon_4']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		// click the grid view

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		// Check the project name is displayed or not

		Thread.sleep(4000);
		String Projectnamegridtxt = "Automationtest";
		WebElement Projectnamegrid = driver.findElement(By.xpath("//*[text()='Automationtest']"));
		if (Projectnamegrid.isDisplayed()) {
			Assert.assertEquals(Projectnamegridtxt, Projectnamegrid.getText());
			System.out.println("Project Name is displayed");
			// check the project name is valid
		} else {
			System.out.println("Project Name is not displayed");

		}
		// Check the project type is displayed or not
		String Projecttypetxt = "Healthcare";
		WebElement Projecttypeelement = driver.findElement(By.xpath("//*[text()='Healthcare']"));
		if (Projecttypeelement.isDisplayed()) {
			System.out.println("Project type is displayed");
			String text = Projecttypeelement.getText();
			if (Projecttypetxt.equals(text)) {
				System.out.println("Project type is matched");
			} else {
				System.out.println(" project type is not matched");
			}
		} else {
			System.out.println("Project type is not displayed ");
		}
		// Check the projectSub type is displayed or not
		String projectSubtypetxt = "Hospital";
		WebElement projectSubtypeelement = driver.findElement(By.xpath("//*[text() ='Hospital']"));
		if (projectSubtypeelement.isDisplayed()) {
			Assert.assertEquals(projectSubtypetxt, projectSubtypeelement.getText());
			System.out.println("projectSub  is displayed");
		} else {
			System.out.println("projectSub  is not displayed");
		}
		// Check the Construction type is displayed or not
		String Constructiontypetxt1 = "New";
		WebElement Constructiontypegridaa = driver.findElement(By.xpath("//*[text() ='New']"));
		if (Constructiontypegridaa.isDisplayed()) {
			Assert.assertEquals(Constructiontypetxt1, Constructiontypegridaa.getText());
			System.out.println("Constructiontype  is displayed");
		} else {
			System.out.println("projectSub  is not displayed");
		}
		// Check the Start date is displayed or not
		Thread.sleep(5000);
		String sdate = "08/20/2019";
		WebElement Startdateele = driver.findElement(By.xpath("//*[text() ='08/20/2019']"));
		if (Startdateele.isDisplayed()) {
			Assert.assertEquals(sdate, Startdateele.getText());
			System.out.println("Startdate is displayed");
		} else {
			System.out.println("Startdate is not  displayed");
		}
		// Check the End date is displayed or not
		String enddate = "09/06/2019";
		WebElement Endadateele2 = driver.findElement(By.xpath("//*[text() ='09/06/2019']"));
		if (Endadateele2.isDisplayed()) {
			Assert.assertEquals(enddate, Endadateele2.getText());
			System.out.println("Enddate is displayed");
		} else {
			System.out.println("Enddate is not  displayed");
		}
		// click the Rule button

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class ='icon-rules']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		System.out.println("rules pass");
		Thread.sleep(2000);
		// click the issues button
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class ='icon-issue']")).click();
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("isssues pass");
		// click the overview button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class ='icon-info']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("overview pass");
		// click the subfolder button

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class ='icon-sub-project']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("subfolder pass");
		// click the Module viewer button

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class ='icon-d-viewer']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[2]")).click();
		Thread.sleep(5000);
		// check the filter option in project type

		Thread.sleep(6000);
		WebElement doubleclick = driver.findElement(By.xpath("(//*[@class ='e-sortfilterdiv e-icons'])[1]"));
		Actions act = new Actions(driver);
		act.doubleClick(doubleclick).perform();

		Thread.sleep(5000);
		// Click the column chooser button

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class ='dropdown-nav dropdown-toggle add-project'])[1]")).click();
		Thread.sleep(2000);
		// select the column in column chooser

		driver.findElement(By.xpath("//*[@placeholder ='Search']")).sendKeys("project");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class = 'e-ccsearch-icon e-icons e-cc e-input-group-icon e-cc-cancel']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@placeholder ='Search']")).sendKeys("project");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//span[@title='Search']")).click();
		System.out.println("Serach is clicked");
		List<WebElement> Elements = driver.findElements(By.xpath("//*[@class ='e-frame e-icons e-check']"));
		for (int i = 0; i < Elements.size(); i++) {
			System.out.println(Elements.size());
			Elements.get(i).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='dropdown-nav dropdown-toggle add-project'])[3]")).click();

		System.out.println("All functionlitied are workng well");
		Thread.sleep(4000);
		// Click the Project overview info button
		driver.findElement(By.xpath("(//*[@class ='project-image'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class ='col text-center'])[2]")).click();
		Thread.sleep(4000);

		// close the preview image
		driver.findElement(By.xpath("//*[text()='X']")).click();
		driver.navigate().back();
		// Click the sub folder icon and clicks the create button
		Thread.sleep(2000);
		driver.findElement(By.id("icon_3")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()=' Create ']")).click();
		Thread.sleep(2000);
		// Click the project name field but not entered the value
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='projectName']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='parentProjectId']")).click();
		Thread.sleep(2000);
		// Validate the validation message
		String validationmsage1 = "Project Name is required";
		String Validusername1 = driver.findElement(By.xpath("//*[text() ='Project Name is required']")).getText();
		System.out.println(Validusername1);
		if (validationmsage1.contains(Validusername1)) {
			System.out.println("projectname validation message are same");
		} else {
			System.out.println("projectname validation message are different");
		}

		// Enter the inValid userName and validate the validation message

		WebElement Projectnamesub = driver.findElement(By.xpath("//*[@id='projectName']"));
		Projectnamesub.sendKeys("hcgvjhdvfhdjggjhdggjgkgkfdhgkjfdgfkld");
		driver.findElement(By.xpath("//*[@id='parentProjectId']")).click();
		Thread.sleep(3000);
		String Invalidnamesub = "Project Name allowed 16 characters only";
		String projectnamevalidationmessagesub = driver
				.findElement(By.xpath("//*[text() = 'Project Name allowed 16 characters only.']")).getText();
		System.out.println(projectnamevalidationmessagesub);
		if (Invalidnamesub.equalsIgnoreCase(projectnamevalidationmessagesub)) {
			System.out.println(" projectname validation message are same");
		} else {
			System.out.println("projectname validation message are different");
		}
		Projectnamesub.clear();
		Thread.sleep(4000);
		// Enter the Valid userName

		driver.findElement(By.xpath("//*[@id='projectName']")).sendKeys("Sasasasasa");
		Thread.sleep(2000);
		// Enter the Valida Address
		driver.findElement(By.xpath("//*[@formcontrolname ='ProjectAddress']")).sendKeys("sasasascxcxcxcxcczczczxzx");
		// click the description field but not enter the value
		driver.findElement(By.id("Description")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@formcontrolname ='ProjectAddress']")).click();
		Thread.sleep(3000);
		String description1sub = driver.findElement(By.xpath("//*[text() ='Description is required']")).getText();
		System.out.println(description1sub);
		Thread.sleep(2000);
		driver.findElement(By.id("Description")).sendKeys("37654375987432659832659382659803265982");
		// upload the image
		WebElement uploadsub = driver.findElement(By.xpath("//*[@class = 'fa fa-upload fa-2x pointer large']"));
		Thread.sleep(2000);
		uploadsub.click();
		Thread.sleep(2000);
		Screen screensub = new Screen();
		screensub.type("C:\\Users\\Ajithkumar.Gopal\\Pictures\\Saved Pictures\\tulips-1531279-640x480.jpg");
		Thread.sleep(5000);
		Robot robotsub = new Robot();
		robotsub.keyPress(KeyEvent.VK_ENTER);
		robotsub.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		// Clicks the cancel button
		// driver.findElement(By.xpath("//*[@class='btn btn-secondary']")).click();
		driver.navigate().back();
		// driver.findElement(By.xpath("(//*[@class='iconicCard'])[4]")).click();
		Thread.sleep(3000);
		// check the subproject name

		WebElement subprojectname1 = driver.findElement(By.xpath("//*[@class='card-item-title']"));
		if (subprojectname1.isDisplayed()) {
			System.out.println("Subproject name is displayed");
			Assert.assertEquals("SUBTEST", subprojectname1.getText());
		} else {
			System.out.println("Subproject name is not  displayed");
		}
		// check the subproject type
		Thread.sleep(3000);
		WebElement projettypesubs = driver.findElement(By.xpath("//*[text()='Healthcare']"));
		if (projettypesubs.isDisplayed()) {
			System.out.println("projecttype is displayed");
			Assert.assertEquals("Healthcare", projettypesubs.getText());
		} else {
			System.out.println("projecttype is not  displayed");
		}
		// check the Project sub type
		Thread.sleep(2000);
		WebElement projectsubtypeaaa = driver.findElement(By.xpath("//*[text()='Hospital']"));
		if (projectsubtypeaaa.isDisplayed()) {
			System.out.println("projectsubtype is displayed");
			Assert.assertEquals("Hospital", projectsubtypeaaa.getText());
		} else {
			System.out.println("projectsubtype is not  displayed");
		}
		// Check the Construction type
		Thread.sleep(2000);
		WebElement Constructiontypessasa = driver.findElement(By.xpath("//*[text()='New']"));
		if (Constructiontypessasa.isDisplayed()) {
			System.out.println("projectsubtype is displayed");
			Assert.assertEquals("New", Constructiontypessasa.getText());
		} else {
			System.out.println("projectsubtype is not  displayed");
		}
		Thread.sleep(5000);
		// Click the rules icon
		driver.findElement(By.xpath("(//*[@class='iconicCard ng-star-inserted'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("Action is clicked");
		driver.findElement(By.id("BackToProjects")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("icon_3")).click();

		Thread.sleep(5000);
		// Click the Overview icon
		driver.findElement(By.xpath("(//*[@class='iconicCard ng-star-inserted'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BackToProjects")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='icon_3']")).click();
		Thread.sleep(3000);
		// Click the issues icon
		driver.findElement(By.xpath("(//*[@class='iconicCard ng-star-inserted'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BackToProjects")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='icon_3']")).click();
		Thread.sleep(3000);
		// click the subfolder icon
		driver.findElement(By.xpath("(//*[@class='iconicCard ng-star-inserted'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BackToProjects")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='icon_3']")).click();
		Thread.sleep(3000);
		// click the Module viewer icon
		driver.findElement(By.xpath("(//*[@class='iconicCard ng-star-inserted'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BackToProjects")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='icon_3']")).click();
		Thread.sleep(3000);
		System.out.println("All functionlitied are workng well");
		driver.navigate().back();
	}
}