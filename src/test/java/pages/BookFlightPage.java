package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
 
public class BookFlightPage 
{
 
	WebDriver driver;
 
public BookFlightPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver, this);
}

@FindBy(xpath = "//input[@id='inputName']")
WebElement firstNametxtbx;

@FindBy(xpath ="//input[@id='address']")
WebElement addresstxtbx;

@FindBy(xpath ="//input[@id='city']")
WebElement citytxtbx;

@FindBy(xpath ="//input[@id='state']")
WebElement statetxtbx;

@FindBy(xpath ="//input[@id='zipCode']")
WebElement zipCodetxtbx;

@FindBy(xpath ="//select[@id='cardType']")
WebElement cardTypedrpdwn;

@FindBy(xpath ="//input[@id='creditCardNumber']")
WebElement creditCardNumbertxtbx;

@FindBy(xpath ="//input[@id='creditCardMonth']")
WebElement creditCardMonthtxtbx;

@FindBy(xpath ="//input[@id='creditCardNumber']")
WebElement nameOnCardtxtbx;

@FindBy(xpath ="//input[@id='creditCardYear']")
WebElement creditCardYeartxtbx;

@FindBy(xpath ="//input[@id='rememberMe']")
WebElement rememberMechkbx;

@FindBy(xpath ="//input[@type='submit']")
WebElement purchaseFlightbtn;


	public void ConfirmFlightBooking(String UserFirstName,String  Address, String City, String State, String zipcode, String CardType,String CardNo, String Month, String Year, String NameOnCard ) throws InterruptedException
	{
		try
		{
			Thread.sleep(1000);
			//System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "BlazeDemo Purchase", "The user naviagted to Flight reservation page successfully");
		    firstNametxtbx.sendKeys(UserFirstName);
		    addresstxtbx.sendKeys(Address);
		    citytxtbx.sendKeys(City);
		    statetxtbx.sendKeys(State);
		    zipCodetxtbx.sendKeys(zipcode);
		    
		    Select selcardType = new Select(cardTypedrpdwn);
		    List<WebElement> listoption = selcardType.getOptions();
		 // Loop to select the desired card type
		    for(WebElement option1 : listoption)
		    {
		        if(option1.getText().equals(CardType)) {
		            option1.click();
		            break;
		        }
		    }
		    creditCardNumbertxtbx.sendKeys(CardNo);
		    creditCardMonthtxtbx.sendKeys(Month);
		    creditCardYeartxtbx.sendKeys(Year);
		    creditCardYeartxtbx.sendKeys(NameOnCard);
		    Assert.assertTrue(rememberMechkbx.isDisplayed());
		    purchaseFlightbtn.click();
		}
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
