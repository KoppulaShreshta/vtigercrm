package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactDetailsPage {

	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']") 
	private WebElement pageHeader;
	
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement contactsLink;
	
	//intialization
	public NewContactDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
		
	}
	public void clickContactsLink() {
		contactsLink.click();
	}
	
}
