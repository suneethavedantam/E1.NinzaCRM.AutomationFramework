package ninzaCRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CampaignPage extends SeleniumUtility {

	@FindBy(xpath = ("//span[.='Create Campaign']"))
	private WebElement createCampaignBtn;
	
	@FindBy(linkText ="Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText ="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement userIcon;
	
	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logoutLnk;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadsLink() {
		return leadsLnk;
	}
	
	public WebElement getContactsLink() {
		return contactsLnk;
	}
	public WebElement getOpportunitiesLink() {
		return opportunitiesLnk;
	}
	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	public WebElement getLogoutLink() {
		return logoutLnk;
	}

	//Business Library
	
	/**
	* This method will click on createCampaignBtn 
	*/
	public void clickOnCreateCampaignBtn()
	{
		createCampaignBtn.click();
	}
	/**
	 * This method will click on leads link
	 */
	public void clickOnLeadsLnk()
	{
		leadsLnk.click();
	}
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}
	/**
	 * This method will click on opportunities link
	 */
	public void clickOnOpportunitiesLnk()
	{
		opportunitiesLnk.click();
	}
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, userIcon);
		Thread.sleep(4000);
		logoutLnk.click();
	}
}
