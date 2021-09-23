package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.collections4.FactoryUtils;
//import org.apache.commons.io.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
 
public class CaptureScreenshotPage {
 
public CaptureScreenshotPage(){
 
}
 
public static void getScreenShot(WebDriver driver, String filepath) throws FileNotFoundException, IOException {
	try 
	{
		System.out.println("In getScreenShot method");
		TakesScreenshot ts = (TakesScreenshot)driver;
		System.out.println("before getScreenshotAs");
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println("After getScreenshotAs");
		//FactoryUtils.copyFile(source, new File(filepath));
	} 
	catch (WebDriverException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 
public static String getDateTimeStamp(){
Date oDate;
String[] sDatePart;
String sDateStamp;
oDate = new Date();
System.out.println(oDate.toString());
sDatePart = oDate.toString().split(" ");
sDateStamp = sDatePart[5] + "_" +
sDatePart[1] + "_" +
sDatePart[2] + "_" +
sDatePart[3] ;
sDateStamp = sDateStamp.replace(":", "_");
System.out.println(sDateStamp);
return sDateStamp;}
 
}
