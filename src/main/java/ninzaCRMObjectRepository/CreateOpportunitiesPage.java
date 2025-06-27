package ninzaCRMObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateOpportunitiesPage extends SeleniumUtility {

	@FindBy(name = "opportunityName")
	private WebElement opportunityNameTxt;
	
	@FindBy(name = "amount")
	private WebElement amountTxt;
	
	@FindBy(name = "businessType")
	private WebElement businessTypeTxt;
	
	@FindBy(name = "nextStep")
	private WebElement nextStepTxt;
	
	@FindBy(name = "salesStage")
	private WebElement salesStageTxt;
	
	@FindBy(name = "probability")
	private WebElement probabilityTxt;
	
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectLeadBtn;

	@FindBy(id = "search-criteria")
	private WebElement selDropDown;

	@FindBy(id = "search-input")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;

	@FindBy(xpath = "//button[.='Create Opportunity']")
	private WebElement createOpportunityBtn;

	public CreateOpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityNameTxt() {
		return opportunityNameTxt;
	}

	public WebElement getAmountTxt() {
		return amountTxt;
	}

	public WebElement getBusinessTypeTxt() {
		return businessTypeTxt;
	}

	public WebElement getNextStepTxt() {
		return nextStepTxt;
	}

	public WebElement getSalesStageTxt() {
		return salesStageTxt;
	}

	public WebElement getProbabilityTxt() {
		return probabilityTxt;
	}

	public WebElement getSelectLeadBtn() {
		return selectLeadBtn;
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

	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}
	//Business Library
	/**
	 * This method will create opportunity with mandatory fields
	 * @param driver
	 * @param opportunityName
	 * @param amount
	 * @param businessType
	 * @param nextStep
	 * @param salesStage
	 * @param leadName
	 * @param campaignname 
	 * @param rating
	 * @throws InterruptedException
	 */
	public void createOpportunityWithLead(WebDriver driver, String opportunityName, String amount, String businessType, String nextStep,
			String salesStage,String probability, String leadName, String campaignname) throws InterruptedException {
			
			opportunityNameTxt.sendKeys(opportunityName);
			amountTxt.sendKeys(amount);
			businessTypeTxt.sendKeys(businessType);
			nextStepTxt.sendKeys(nextStep);
			salesStageTxt.sendKeys(salesStage);
			probabilityTxt.sendKeys(probability);
			selectLeadBtn.click();
			
			switchToWindow(driver, "Lead");
			Thread.sleep(3000);
			
			handleDropdown("Lead Name", selDropDown);
			searchTxt.sendKeys(leadName);
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//td[.='"+leadName+"']/following-sibling::td/child::button")).click();
			
			Thread.sleep(2000);
			
			switchToWindow(driver, "Ninza");
			
			Thread.sleep(1000);
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
			
			createOpportunityBtn.click();
	}		
}
