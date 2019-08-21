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
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.sikuli.script.Screen;


	public class OverallScenarios {
		
		public static WebDriver driver = WebBrowser.driver;
		public static File src;
		public static FileInputStream fis;
		public static HSSFSheet sh1;
		public static HSSFWorkbook wb;
		
		public static void ProjectValidation() throws InterruptedException, AWTException, IOException {
			
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium files\\Workspace\\SeleniumTraining\\Driver2\\chromedriver.exe");
			driver = new ChromeDriver();
			// Login the application URL
			driver.get("http://192.168.1.154/blm/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys("qc@sst.com");
			driver.findElement(By.id("login-password")).sendKeys("sst12345");
			driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text() =' Create ']")).click();
			System.out.println("pass");

			// touch the project name field but not entered the value

			driver.findElement(By.xpath("//*[@id='projectName']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//*[@class='form-group'])[1]")).click();
			Thread.sleep(2000);
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
			Projectname.sendKeys("Sasasa232323%$#^%$^%@$^sasa");
			driver.findElement(By.xpath("(//*[@class='form-group'])[1]")).click();
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

			// Enter the Valid userName

			driver.findElement(By.xpath("//*[@id='projectName']")).sendKeys("Sasasasasa");
			Thread.sleep(2000);

			// click the project type field and Select the respective project sub type

			driver.findElement(By.xpath("(//*[@class='form-group'])[1]")).click();
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

			driver.findElement(By.xpath("(//*[@class ='form-group'])[2]")).click();
			WebElement projectsubtype = driver.findElement(By.xpath("//*[@formcontrolname='ProjectSubTypeID']"));
			Select sel = new Select(projectsubtype);
			sel.selectByIndex(0);
			String text3 = projectsubtype.getText();
			{
				System.out.println(text3);
			}
			Thread.sleep(2000);

			/*// touch the Life cycle template but not select the value

			driver.findElement(By.xpath("(//*[@class ='form-group'])[3]")).click();
			WebElement lifecycletemplate = driver.findElement(By.xpath("//*[@formcontrolname='LifecycleTemplate']"));
			Select sel1 = new Select(lifecycletemplate);
			sel1.selectByIndex(1);
			Thread.sleep(5000);
			String text4 = lifecycletemplate.getText();
			{
				System.out.println(text4);
			}*/
			/*
			 * //get the validations messsage String gettex =
			 * "Lifecycle Template is required "; System.err.println("pass"); WebElement
			 * element3 =
			 * driver.findElement(By.xpath("//div[text()='Lifecycle Template is required ']"
			 * )); String sss = element3.getText(); System.out.println("asas"+ sss);
			 * System.out.println("pass1"); if (gettex.equals(sss)) {
			 * System.out.println("Both validations are same Lifecycle Template is required"
			 * ); } else { System.out.println("Both validations are different");
			 * 
			 * } Thread.sleep(4000);
			 */

			// touch the Life cycle template and select the value

			driver.findElement(By.xpath("(//*[@class ='form-group'])[3]")).click();
			WebElement element4 = driver.findElement(By.xpath("//*[@formcontrolname='LifecycleTemplate']"));
			Select sel2 = new Select(element4);
			sel2.selectByIndex(1);
			String text5 = element4.getText();
			{
				System.out.println(text5);
			}
			Thread.sleep(2000);

			// touch the Construction type and select the value
			driver.findElement(By.xpath("(//*[@class ='form-group'])[4]")).click();
			WebElement Construction = driver.findElement(By.xpath("//*[@formcontrolname='ConstructionTypeID']"));
			Select sel4 = new Select(Construction);
			sel4.selectByIndex(1);
			String text6 = Construction.getText();
			{
				System.out.println(text6);
			}
			Thread.sleep(2000);

			// touch the contract type and select the value
			driver.findElement(By.xpath("(//*[@class ='form-group'])[5]")).click();
			WebElement contract = driver.findElement(By.xpath("//*[@formcontrolname='ContractTypeID']"));

			Select sel5 = new Select(contract);
			sel5.selectByIndex(1);
			String text7 = contract.getText();
			{
				System.out.println(text7);
			}
			Thread.sleep(2000);

			// touch the start date and validate the validation message

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[1]")).click();

			driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]")).click();
			String startvalid = "Start date is required";
			String dates = driver.findElement(By.xpath("//*[text() =' Start date is required']")).getText();
			if (dates.equals(startvalid)) {
				System.out.println("startdate both validations are same");
			} else {
				System.out.println("startdate Both validations are different");
			}
			Thread.sleep(2000);

			// touch the start date and enter the value
			driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[1]")).sendKeys("08-08-2019");
			Thread.sleep(2000);

			// touch the End date and not select the value
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]")).click();

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

			// touch the End date and enter the Value
			driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]")).sendKeys("08-08-2029");
			Thread.sleep(2000);

			// Enter the valid data in project Address field

			driver.findElement(By.xpath("//*[@formcontrolname ='ProjectAddress']")).sendKeys("dsdsdsdsdsds");
			Thread.sleep(2000);

			// touch the description field but not enter the value
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

			// touch the description field and the enter the value
			driver.findElement(By.id("Description")).sendKeys("cgJHSAahgvfhgdzvcGXZSVcfdhgfdjhsaf");
			Thread.sleep(2000);

			// Upload the respective image
			WebElement upload = driver.findElement(By.xpath("//*[@class = 'fa fa-upload fa-2x pointer large']"));
			Thread.sleep(2000);
			upload.click();
			Thread.sleep(2000);
			Screen screen = new Screen();
			screen.type("C:\\Users\\Ajithkumar.Gopal\\Pictures\\Saved Pictures\\tulips-1531279-640x480.jpg");
			// upload.sendKeys("C:\\Users\\Ajithkumar.Gopal\\Pictures\\Saved
			// Pictures\\tulips-1531279-640x480.jpg");
			Thread.sleep(5000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);

			/*
			 * @Test(enabled = false) public void cancel() throws Exception { // cancel the
			 * project Thread.sleep(2000);
			 * driver.findElement(By.xpath("(//*[@class ='btn btn-secondary'])[1]")).click()
			 * ; }
			 */

			// clear the project
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//*[@class ='btn btn-secondary'])[2]")).click();
		}
}
