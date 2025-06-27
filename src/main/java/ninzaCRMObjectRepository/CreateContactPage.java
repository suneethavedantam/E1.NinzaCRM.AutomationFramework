package ninzaCRMObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateContactPage extends SeleniumUtility{
	
	@FindBy(name = "contactName")
	private WebElement contactNameTxt;

	@FindBy(name = "organizationName")
	private WebElement organizationTxt;
	
	@FindBy(name = "title")
	private WebElement titleTxt;
	
	@FindBy(name = "mobile")
	private WebElement mobileTxt;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;

	@FindBy(id = "search-criteria")
	private WebElement selDropDown;

	@FindBy(id = "search-input")
	private WebElement searchTxt;

	@FindBy(xpath = "//button[.='Create Contact']")
	private WebElement createContactBtn;

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getContactNameTxt() {
		return contactNameTxt;
	}

	public WebElement getOrganizationTxt() {
		return organizationTxt;
	}

	public WebElement getTitleTxt() {
		return titleTxt;
	}

	public WebElement getMobileTxt() {
		return mobileTxt;
	}

	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}

	public WebElement getSelDropDown() {
		return selDropDown;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
  
	//Business Library
	/**
	 * This method will create contact
	 * @param driver
	 * @param ContactName
	 * @param organisation
	 * @param mobile
	 * @param title
	 * @param mobile
	 * @param rating
	 * @param campaignname
	 */
	public void createContactWithCampaign(WebDriver driver, String ContactName,String organization,String mobile,String title, String campaignname)throws InterruptedException{
		
	
	contactNameTxt.sendKeys(ContactName);
	organizationTxt.sendKeys(organization);
	titleTxt.sendKeys(title);
	mobileTxt.sendKeys(mobile);
	
	
	selectCampaignBtn.click();
	
	switchToWindow(driver, "Campaign");
	Thread.sleep(3000);
	
	handleDropdown("Campaign Name", selDropDown);
	searchTxt.sendKeys(campaignname);
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//td[.='"+campaignname+"']/following-sibling::td/child::button")).click();
	
	Thread.sleep(2000);
	
	switchToWindow(driver, "Ninza");
	
	Thread.sleep(1000);
	
	createContactBtn.click();
		
	}

}
