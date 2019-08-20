package CloudBLM.GitHub;

import java.awt.AWTException;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import atu.testrecorder.ATUTestRecorder;


class WarningMessage{
	
	String nullpointerexp ="org.openqa.selenium.NullPointerException";
	String nullpointerexp_text ="<b>No Element is not Found</b>";
	
	String notclickexp ="org.openqa.selenium.NOTCLICK";
	String notclickexp_text ="<b>Unable to click the Button</b>";
	
	String nosuchelementexp="org.openqa.selenium.NoSuchElementException";
	String nosuchelementexp_text ="<b>Excepted Button or Element is not Found</b>";
	
	String e_text ="<b>Unknown Exception</b>";
	
}


public class CloudBLMMaster extends  WarningMessage {
	
	public ExtentTest test;
	public ExtentReports report;
	public ATUTestRecorder Recorder;

	@BeforeTest
	public void Report() throws Exception
	{
		report = new ExtentReports("D:\\Report\\Cloud BLM GitHub Test Report.html");
		test = report.startTest("CloudBLM Report");	
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		Recorder = new ATUTestRecorder("D:\\Report\\", "Cloud BLM GitHub-" + dateFormat.format(date), false);
	
		File file  = new File("fileName.fileExtension"); // creating object of File 
		String str = file.getPath().replace(".fileExtension", ".mp4"); // replacing extension to another 
		file.renameTo(new File(str)); 
		Recorder.start();
	}
	
	@Test(priority=0)
	public void WebBrowser() throws Exception
	{	
	   try {
		WebBrowser.LaunchBrowser();
	   
	   test.log(LogStatus.PASS,"WebBrowser");
    }catch (Exception e ) {
	
	String expstr =e.toString();
	  if(expstr.contains(nullpointerexp))
	  {
		  test.log(LogStatus.FAIL,"WebBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
		  Assert.fail(expstr);
	  }else if(expstr.contains(notclickexp))
	  {
		  test.log(LogStatus.FAIL,"WebBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
		  Assert.fail(expstr);
	  }else if(expstr.contains(nosuchelementexp))
	  {
		  test.log(LogStatus.FAIL,"WebBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
		  Assert.fail(expstr);
	  }else
	  {
		  test.log(LogStatus.FAIL,"WebBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
		  Assert.fail(expstr);
	  }
	  System.out.println(e);
	}
	}
	
	@Test(priority=1)
	public void Login() throws Exception
	{		
		try {
		LoginPage.LoginValidation();
		
			test.log(LogStatus.PASS, "Login Validation");
		} catch (Exception e) {

			String expstr = e.toString();
			if (expstr.contains(nullpointerexp)) {
				test.log(LogStatus.FAIL, "Login Validation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(notclickexp)) {
				test.log(LogStatus.FAIL, "Login Validation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(nosuchelementexp)) {
				test.log(LogStatus.FAIL, "Login Validation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else {
				test.log(LogStatus.FAIL, "Login Validation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
				Assert.fail(expstr);
			}
			System.out.println(e);
		}
	}
	
	/*@Test(priority=2)
	public void CreateProject() throws Exception
	{			
	   try {
		CreateProject.ProjectValidation();
		
			test.log(LogStatus.PASS, "Project Creation");
		} catch (Exception e) {

			String expstr = e.toString();
			if (expstr.contains(nullpointerexp)) {
				test.log(LogStatus.FAIL, "Project Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(notclickexp)) {
				test.log(LogStatus.FAIL, "Project Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(nosuchelementexp)) {
				test.log(LogStatus.FAIL, "Project Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else {
				test.log(LogStatus.FAIL, "Project Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
				Assert.fail(expstr);
			}
			System.out.println(e);
		}
   }
	
	@Test(priority=3)
	public void SubProject() throws Exception
	{			
	   try {
		 SubProject.SubProjectCreation();
		
			test.log(LogStatus.PASS, "SubProject Creation");
		} catch (Exception e) {

			String expstr = e.toString();
			if (expstr.contains(nullpointerexp)) {
				test.log(LogStatus.FAIL, "SubProject Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(notclickexp)) {
				test.log(LogStatus.FAIL, "SubProject Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(nosuchelementexp)) {
				test.log(LogStatus.FAIL, "SubProject Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else {
				test.log(LogStatus.FAIL, "SubProject Creation" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
				Assert.fail(expstr);
			}
			System.out.println(e);
		}
   }
		
	@Test(priority=4)
	public void LaunchRevit() throws Exception
	{			
	   try {
		     Revit_Exporter.Revit();
		
			test.log(LogStatus.PASS, "LaunchRevit");
		} catch (Exception e) {

			String expstr = e.toString();
			if (expstr.contains(nullpointerexp)) {
				test.log(LogStatus.FAIL, "LaunchRevit" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(notclickexp)) {
				test.log(LogStatus.FAIL, "LaunchRevit" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(nosuchelementexp)) {
				test.log(LogStatus.FAIL, "LaunchRevit" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else {
				test.log(LogStatus.FAIL, "LaunchRevit" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
				Assert.fail(expstr);
			}
			System.out.println(e);
		}
   }
	
	@Test(priority=5)
	public void RevitLogin() throws Exception
	{			
	   try {
		   Revit_Login.Login();
		
			test.log(LogStatus.PASS, "RevitLogin");
		} catch (Exception e) {

			String expstr = e.toString();
			if (expstr.contains(nullpointerexp)) {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(notclickexp)) {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(nosuchelementexp)) {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
				Assert.fail(expstr);
			}
			System.out.println(e);
		}
   }
	
	@Test(priority=6)
	public void RevitProject() throws Exception
	{			
	   try {
		   Revit_ProjectSelection.RevitProject();
		
			test.log(LogStatus.PASS, "RevitLogin");
		} catch (Exception e) {

			String expstr = e.toString();
			if (expstr.contains(nullpointerexp)) {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(notclickexp)) {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(nosuchelementexp)) {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else {
				test.log(LogStatus.FAIL, "RevitLogin" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
				Assert.fail(expstr);
			}
			System.out.println(e);
		}
   }
	
	@Test(priority=7)
	public void SearchProject() throws Exception
	{			
	   try {
		SearchProject.ProjectSelection();
		
		test.log(LogStatus.PASS, "SearchProject");
		} catch (Exception e) {

			String expstr = e.toString();
			if (expstr.contains(nullpointerexp)) {
				test.log(LogStatus.FAIL, "SearchProject" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(notclickexp)) {
				test.log(LogStatus.FAIL, "SearchProject" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else if (expstr.contains(nosuchelementexp)) {
				test.log(LogStatus.FAIL, "SearchProject" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
				Assert.fail(expstr);
			} else {
				test.log(LogStatus.FAIL, "SearchProject" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
						+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
				Assert.fail(expstr);
			}
			System.out.println(e);
		}
   }
	
	@Test(priority=8)
	public void Model_Viewer() throws InterruptedException, AWTException
	{
		try {		
	     	ModelViewer.Viewer();
		
		test.log(LogStatus.PASS, "ManageIssues");
	} catch (Exception e) {

		String expstr = e.toString();
		if (expstr.contains(nullpointerexp)) {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(notclickexp)) {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(nosuchelementexp)) {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
			Assert.fail(expstr);
		}
		System.out.println(e);
	}
	}	
	
	@Test(priority=9)
	public void Model_Viewer_Toolbar() throws InterruptedException, AWTException
	{
		try {		
	     	ViewerTool.Tooloption();
		
		test.log(LogStatus.PASS, "Model_Viewer_Toolbar");
	} catch (Exception e) {

		String expstr = e.toString();
		if (expstr.contains(nullpointerexp)) {
			test.log(LogStatus.FAIL, "Model_Viewer_Toolbar" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(notclickexp)) {
			test.log(LogStatus.FAIL, "Model_Viewer_Toolbar" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(nosuchelementexp)) {
			test.log(LogStatus.FAIL, "Model_Viewer_Toolbar" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else {
			test.log(LogStatus.FAIL, "Model_Viewer_Toolbar" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
			Assert.fail(expstr);
		}
		System.out.println(e);
	}
	}		
	
	@Test(priority=10)
	public void ManageIssues() throws InterruptedException, AWTException
	{
		try {		
	     	Manage_Issues.IssuesValidation();
		
		test.log(LogStatus.PASS, "ManageIssues");
	} catch (Exception e) {

		String expstr = e.toString();
		if (expstr.contains(nullpointerexp)) {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(notclickexp)) {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(nosuchelementexp)) {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else {
			test.log(LogStatus.FAIL, "ManageIssues" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
			Assert.fail(expstr);
		}
		System.out.println(e);
	}
	}	
	
	@Test(priority=11)
	public void Grouping() throws InterruptedException, AWTException
	{
		try {		
	     	Grouping.Group();
		
		test.log(LogStatus.PASS, "Grouping");
	} catch (Exception e) {

		String expstr = e.toString();
		if (expstr.contains(nullpointerexp)) {
			test.log(LogStatus.FAIL, "Grouping" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(notclickexp)) {
			test.log(LogStatus.FAIL, "Grouping" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(nosuchelementexp)) {
			test.log(LogStatus.FAIL, "Grouping" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else {
			test.log(LogStatus.FAIL, "Grouping" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
			Assert.fail(expstr);
		}
		System.out.println(e);
	}
	}
	
	@Test(priority=12)
	public void Dimensions() throws InterruptedException, AWTException
	{
		try {		
			Dimensions.Dimension();
		
		test.log(LogStatus.PASS, "Dimensions");
	} catch (Exception e) {

		String expstr = e.toString();
		if (expstr.contains(nullpointerexp)) {
			test.log(LogStatus.FAIL, "Dimensions" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(notclickexp)) {
			test.log(LogStatus.FAIL, "Dimensions" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(nosuchelementexp)) {
			test.log(LogStatus.FAIL, "Dimensions" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else {
			test.log(LogStatus.FAIL, "Dimensions" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
			Assert.fail(expstr);
		}
		System.out.println(e);
	}
	}

	@Test(priority=13)
	public void ManageRule() throws InterruptedException, AWTException
	{
		try {		
			Rules.RulesIssues();
		
		test.log(LogStatus.PASS, "ManageRule");
	} catch (Exception e) {

		String expstr = e.toString();
		if (expstr.contains(nullpointerexp)) {
			test.log(LogStatus.FAIL, "ManageRule" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nullpointerexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(notclickexp)) {
			test.log(LogStatus.FAIL, "ManageRule" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ notclickexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else if (expstr.contains(nosuchelementexp)) {
			test.log(LogStatus.FAIL, "ManageRule" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ nosuchelementexp_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + expstr);
			Assert.fail(expstr);
		} else {
			test.log(LogStatus.FAIL, "ManageRule" + "<br />" + "<b style='color:#FF0000';>Reason: </b>"
					+ e_text + "<br />" + "<b style='color:#FF0000';>Exception: </b>" + e.toString());
			Assert.fail(expstr);
		}
		System.out.println(e);
	}
	}*/
	
	@AfterTest
	public void Exit() throws Exception
	{
		System.out.println("END");
		Recorder.stop();
		test.log(LogStatus.PASS,"Quit");
		report.endTest(test);
		report.flush();
	}
}
