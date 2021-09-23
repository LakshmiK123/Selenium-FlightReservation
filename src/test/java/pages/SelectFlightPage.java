package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
 
public class SelectFlightPage {
 
WebDriver driver;
 
public SelectFlightPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver, this);
}

@FindBy(xpath = "//table[@class='table']")
WebElement flightlistTable;

@FindBy(xpath = "//table[@class='table']/thead/tr/th")
List<WebElement> flightlistTableheader;

@FindBy(xpath = "//table[@class='table']/tbody/tr")
List<WebElement> allRows;

@FindBy(xpath ="//input[@class='btn btn-small']")
WebElement chooseflightbtn;

public void chooseFlight(String price)
{
	//To locate table.
	WebElement mytable = driver.findElement(By.xpath("//table[@class='table']/tbody"));
	//To locate rows of table. 
	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	int rows_count = rows_table.size();
	System.out.println(rows_count);
	System.out.println("Books with price greater than and equal to 1000 are below:");
	//Loop will execute till the last row of table.
	for (int row = 1; row < rows_count; row++) 
	{
	    //To locate columns(cells) of that specific row.
	   // List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		WebElement priceColumn=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+row+"]/td[6]"));
	    if(priceColumn.getText().equals(price))
        {
	    	WebElement chooseFlightbtn=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+row+"]/td[1]/input[@class='btn btn-small']"));
            chooseFlightbtn.click();                                                 
            Reporter.log("Flight selection is successful");
            break;
         }
      }
}
 
}
