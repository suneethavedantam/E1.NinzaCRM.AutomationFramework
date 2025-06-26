package ninzaCRMObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath=("//span[.='Create Contact']"))
	private WebElement createContactBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> ContactNamesTxt;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public List<WebElement> getContactNamesTxt() {
		return ContactNamesTxt;
	}

	//Business Library
	
	/**
	 * This method will click on create contact button
	 */
	public void clickOnCreateContactBtn()
	{
		createContactBtn.click();
	}
	
	/**
	 * This method will capture all the Contact names and Compare with required Contact Name
	 * @param RequiredLeadName
	 */
	public void captureContactNamesAndCompare(String RequiredContactName)
	{
		for (WebElement element : ContactNamesTxt) {
			 
			String ContactName = element.getText();
			if(ContactName.equals(RequiredContactName))
			{
				System.out.println("Contact Created");
				break;
			}
		}
	}

}
