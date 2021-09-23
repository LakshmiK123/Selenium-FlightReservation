package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
 
public class FlightConfirmationPage {
 
WebDriver driver;
 
public FlightConfirmationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver, this);
}
 
@FindBy(xpath = "//h1[text()='Thank you for your purchase today!']")
WebElement successmsg;

@FindBy(xpath ="//input[@id='address']")
WebElement addresstxtbx;
 
public void ConfirmationMessage() throws InterruptedException
{
	Thread.sleep(1000);
	Assert.assertEquals(driver.getTitle(), "BlazeDemo Confirmation", "The Flight Confirmation successfull");
	//To locate table.
	WebElement mytable = driver.findElement(By.xpath("//table[@class='table']/tbody"));
	//To locate rows of table. 
	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	int rows_count = rows_table.size();
	System.out.println(rows_count);
	Reporter.log("The details of the flight reservation is as below");
	//Loop will execute till the last row of table.
	for (int row = 0; row < rows_count; row++) 
	{
	    //To locate columns(cells) of that specific row.
	   List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	   String celtext1 = Columns_row.get(0).getText();
	   String celtext2 = Columns_row.get(1).getText();
	   System.out.println(celtext1+" : "+celtext2);
	   Reporter.log(celtext1+" : "+celtext2);
	 }
}
}