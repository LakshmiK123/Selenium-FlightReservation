package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
 
public class FlightFinderPage 
{
 	WebDriver driver;
 
public FlightFinderPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//div[@class='jumbotron']")
WebElement WelcomePageheading;

@FindBy(xpath = "//div[@class='container']/h2")
WebElement departurecitytxt;

@FindBy(xpath ="//select[@name='fromPort']")
WebElement departureFromdrpdwn;

@FindBy(xpath ="//h2[text()='Choose your destination city:']")
WebElement destinationcitytxt;

@FindBy(xpath = "//select[@name='toPort']")
WebElement departureTodrpdwn;

@FindBy(xpath = "//input[@type='submit']")
WebElement FindFlightsbtn;

@FindBy(xpath = "//a[@href='vacation.html']")
WebElement detinationOftheWeekLink;

@FindBy(xpath = "//a[@href='index.php']")
WebElement TravelTheWorld_menuicon;

@FindBy(xpath = "//a[@href='home']")
WebElement Home_menuicon;

@FindBy(xpath = "//div[@class='container']/h3")
WebElement FlightsListPageheading;

	public void findflights(String FromCity,String ToCity) throws InterruptedException
	{
		//String WelcomePageExpectedheading = "";
		String WelcomePageActualheading = WelcomePageheading.getText();
		Reporter.log(WelcomePageActualheading);
		Select FromList = new Select(departureFromdrpdwn);
		List<WebElement> fromOptions = FromList.getOptions();
		
		//Get the length
	   System.out.println(fromOptions.size());

	    // Loop to print one by one
	    for(WebElement option1 : fromOptions){
	        if(option1.getText().equals(FromCity)) {
	            option1.click();
	            break;
	        }
	    }
	    
	    Select ToList = new Select(departureTodrpdwn);
		List<WebElement> ToOptions = ToList.getOptions();
		
		//Get the length
	   System.out.println(ToOptions.size());

	    // Loop to print one by one
	    for(WebElement option2 : ToOptions){
	        if(option2.getText().equals(ToCity)) {
	            option2.click();
	            break;
	        }
	    }
	    Reporter.log("The From and To dropdown selected successfully");
	    FindFlightsbtn.click();
	    Thread.sleep(500);
	    if(FlightsListPageheading.getText().equals("Flights from "+FromCity+" to "+ToCity+" :"))
	    {
	    	Reporter.log("The list of Flights are displayed for expected From and To cities");
	    }
	}
}

