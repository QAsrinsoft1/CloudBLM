package CloudBLM.GitHub;

import java.awt.AWTException;
import java.io.IOException;
import org.sikuli.script.FindFailed;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;

public class ErrorReport {
	
	String nullpointerexp ="org.openqa.selenium.NullPointerException";
	String nullpointerexp_text ="<b>Excepted Element is not Found</b>";
	
	String notclickexp ="org.openqa.selenium.NOTCLICK";
	String notclickexp_text ="<b>Excepted Button is not Found</b>";
	
	String nosuchelementexp="org.openqa.selenium.NoSuchElementException";
	String nosuchelementexp_text ="<b>Excepted UI or Button is not Found</b>";
	
	String e_text ="<b>Unknown Exception</b>";
	
	public ExtentTest test;
	
	public void Report() throws InterruptedException, AWTException, IOException, FindFailed {
		
	  try{
		  System.out.println("No Exception");
	  }		
	  catch (Exception e) {

	String expstr =e.toString();
	  if(expstr.contains(nullpointerexp))
	  {
		  test.log(LogStatus.FAIL,"Report"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
		  Assert.fail(expstr);
	  }else if(expstr.contains(notclickexp))
	  {
		  test.log(LogStatus.FAIL,"Report"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
		  Assert.fail(expstr);
	  }else if(expstr.contains(nosuchelementexp))
	  {
		  test.log(LogStatus.FAIL,"Report"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
		  Assert.fail(expstr);
	  }else
	  {
		  test.log(LogStatus.FAIL,"Report"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
		  Assert.fail(expstr);
	  }
	  System.out.println(e);
	}

	}
}
