package testcases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BookFlightPage;
import pages.FlightConfirmationPage;
import pages.FlightFinderPage;
import pages.SelectFlightPage;
import resources.BaseClass;

public class FindFlightsTC extends BaseClass
{
	WebDriver driver;
	BaseClass Baseobj = new BaseClass();
	
	@BeforeTest
	public WebDriver beforeTest() 
	{
		driver = Baseobj.getDriver();
		return driver;
		
	}
	@Test
	public void FindFlights() 
	{
		
		try 
		{
			System.out.println("Welcome Page");
			BookFlightPage bookFlight = new BookFlightPage(driver);
			FlightFinderPage findflight = new FlightFinderPage(driver);
			SelectFlightPage selectflight = new SelectFlightPage(driver);
			FlightConfirmationPage confirmdetails = new FlightConfirmationPage(driver);
			
			findflight.findflights("Philadelphia", "London");
			selectflight.chooseFlight("$200.98");
			bookFlight.ConfirmFlightBooking("Jhon","#32,CA","PLV","Philadephia","45872","American Express", "254878596365448", "12", "22","Jhon Marth");
			confirmdetails.ConfirmationMessage();
			
		try 
		{
			//CaptureScreenshotPage.getScreenShot(BrowserFactory.getDriver(), bookingDetailsFile);
		} 
		catch (Exception e) {e.printStackTrace();}
	 
		//flightConfirmationPage.logoutPress();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	@AfterTest
	public void afterTest() 
	{
		driver.close();
		
	}
	
}
