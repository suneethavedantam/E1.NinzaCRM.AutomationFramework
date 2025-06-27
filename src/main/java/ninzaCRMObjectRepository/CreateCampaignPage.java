package ninzaCRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	@FindBy(name = "campaignName")
	private WebElement campaignNameTxt;
	
	@FindBy(name = "targetSize")
	private WebElement targetSizeTxt;
	
	@FindBy(xpath = "//button[.='Create Campaign']")
	private WebElement createCampaignBtn;
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignNameTxt() {
		return campaignNameTxt;
	}
	
	public WebElement getTargetSizeTxt() {
		return targetSizeTxt;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	//Business library
	
	/**
	 * This method will create campaign with mandatory fields
	 * @param CampaignName
	 * @param TargetSize
	 */
	public void createCampaign(String CampaignName, String TargetSize)
		{
			campaignNameTxt.sendKeys(CampaignName);
			targetSizeTxt.sendKeys(TargetSize);
			createCampaignBtn.click();
		}
}
