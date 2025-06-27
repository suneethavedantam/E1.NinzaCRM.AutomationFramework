package ninzaCRMObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	@FindBy(xpath=("//span[.='Create Opportunity']"))
	private WebElement createOpportunityBtn;
	
	@FindBy(xpath = "//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> OpportunitiesNamesTxt;
	
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}

	public List<WebElement> getOpportunitiesNamesTxt() {
		return OpportunitiesNamesTxt;
	}

	//Business Library
	/**
	 * This method will click on create Opportunity button
	 */
	public void clickOnCreateOpportunityBtn()
	{
		createOpportunityBtn.click();
	}
	
	/**
	 * This method will capture all the Opportunities names and Compare with required Opportunity Name
	 * @param RequiredOpportunityName
	 */
	public void captureOpportuniesNamesAndCompare(String RequiredOpportunityName)
	{
		for (WebElement element : OpportunitiesNamesTxt) {
			 
			String OpportunityName = element.getText();
			if(OpportunityName.equals(RequiredOpportunityName))
			{
				System.out.println("Opportunity Created");
				break;
			}
		}
	}
	
}
