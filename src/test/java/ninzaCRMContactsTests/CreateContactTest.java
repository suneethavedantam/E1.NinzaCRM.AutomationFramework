package ninzaCRMContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRMObjectRepository.CampaignPage;
import ninzaCRMObjectRepository.ContactsPage;
import ninzaCRMObjectRepository.CreateCampaignPage;
import ninzaCRMObjectRepository.CreateContactPage;
import ninzaCRMObjectRepository.CreateLeadPage;
import ninzaCRMObjectRepository.LeadsPage;

public class CreateContactTest extends BaseClass{

	@Test
	public void tc_02_createContactWithCampaign() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read Test Data from excel File
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 4, 2)+jUtil.getRandomNumber();
		System.out.println(CAMPAIGNNAME);
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 4, 3);
		
		String CONTACTNAME = eUtil.readDataFromExcel("Integration", 4, 4);
		String MOBILE = eUtil.readDataFromExcel("Integration", 4, 5);
		String ORGANIZATION = eUtil.readDataFromExcel("Integration", 4, 6);
		String TITLE = eUtil.readDataFromExcel("Integration", 4, 7);
		
		
		//Click on create campaign
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		//Create campaign with mandatory fields
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(8000);
		
		//Click on Contact Link
		cp.clickOnContactsLnk();
		
		//click on create contact button
		ContactsPage cp1 = new ContactsPage(driver);
		cp1.clickOnCreateContactBtn();
		
		//Create contact with mandatory fields
		CreateContactPage ccp1 = new CreateContactPage(driver);
		ccp1.createContactWithCampaign(driver, CONTACTNAME, MOBILE, ORGANIZATION, TITLE, CAMPAIGNNAME);
		
		//Validate for the contact
		cp1.captureContactNamesAndCompare(CONTACTNAME);
		System.out.println(CONTACTNAME);
		
		Thread.sleep(8000);
	}


	
}
