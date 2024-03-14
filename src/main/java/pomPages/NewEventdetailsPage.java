package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewEventdetailsPage {
     //declaration
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	//intialization
	public NewEventdetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	
	//utilization
	public String getPageHeader() {
		 
	return pageHeader.getText();
		}
}
