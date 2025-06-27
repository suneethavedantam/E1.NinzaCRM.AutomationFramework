package ninzaCRMObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateLeadPage extends SeleniumUtility{
	
	
	@FindBy(name = "name")
	private WebElement leadNameTxt;

	@FindBy(name = "company")
	private WebElement companyNameTxt;

	@FindBy(name = "leadSource")
	private WebElement leadSourceTxt;

	@FindBy(name = "industry")
	private WebElement industryTxt;

	@FindBy(name = "phone")
	private WebElement phoneTxt;

	
	@FindBy(name = "leadStatus")
	private WebElement leadStatusTxt;

	@FindBy(name = "rating")
	private WebElement ratingTxt;

	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;

	@FindBy(id = "search-criteria")
	private WebElement selDropDown;

	@FindBy(id = "search-input")
	private WebElement searchTxt;

	@FindBy(xpath = "//button[.='Create Lead']")
	private WebElement createLeadBtn;

	public CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadNameTxt() {
		return leadNameTxt;
	}

	public WebElement getCompanyNameTxt() {
		return companyNameTxt;
	}

	public WebElement getLeadSourceTxt() {
		return leadSourceTxt;
	}

	public WebElement getIndustryTxt() {
		return industryTxt;
	}

	public WebElement getPhoneTxt() {
		return phoneTxt;
	}

	public WebElement getLeadStatusTxt() {
		return leadStatusTxt;
	}

	public WebElement getRatingTxt() {
		return ratingTxt;
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

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	// Business library
	/**
	 * This method will create lead with mandatory fields
	 * @param driver
	 * @param LeadName
	 * @param CompName
	 * @param leadSource
	 * @param industry
	 * @param phone
	 * @param leadStatus
	 * @param rating
	 * @param campaignname
	 * @throws InterruptedException
	 */
	public void createLeadWithCampaign(WebDriver driver, String LeadName, String CompName, String leadSource, String industry,
		String phone, String leadStatus, String rating, String campaignname) throws InterruptedException {
		
		leadNameTxt.sendKeys(LeadName);
		companyNameTxt.sendKeys(CompName);
		leadSourceTxt.sendKeys(leadSource);
		industryTxt.sendKeys(industry);
		phoneTxt.sendKeys(phone);
		leadStatusTxt.sendKeys(leadStatus);
		ratingTxt.sendKeys(rating);
		
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
		
		createLeadBtn.click();
			
	}

}
