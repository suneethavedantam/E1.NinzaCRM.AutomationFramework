package ninzaCRMLeadsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRMObjectRepository.CampaignPage;
import ninzaCRMObjectRepository.CreateCampaignPage;
import ninzaCRMObjectRepository.CreateLeadPage;
import ninzaCRMObjectRepository.LeadsPage;

public class CreateLeadTest extends BaseClass{

	@Test
	public void createLead() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read Test Data from excel File
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 1, 2)+jUtil.getRandomNumber();
		System.out.println(CAMPAIGNNAME);
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 1, 3);
			
		String LEADNAME = eUtil.readDataFromExcel("Integration", 1, 4);
		String COMPANY = eUtil.readDataFromExcel("Integration", 1, 5);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration", 1, 6);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration", 1, 7);
		String INDUSTRY = eUtil.readDataFromExcel("Integration", 1, 8);
		String RATING = eUtil.readDataFromExcel("Integration", 1, 9);
		String PHONE = eUtil.readDataFromExcel("Integration", 1, 10);
		
		
		//Click on create campaign
		CampaignPage cp = new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		//Create campaign with mandatory fields
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(8000);
		
		//Click on leads Link
		cp.clickOnLeadsLnk();
		
		//click on create lead button
		LeadsPage lp = new LeadsPage(driver);
		lp.clickOnCreateLeadBtn();
		
		//Create lead with mandatory fields
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.createLeadWithCampaign(driver, LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS, RATING, CAMPAIGNNAME);
		
		//Validate for the lead
		lp.captureLeadNamesAndCompare(LEADNAME);
		System.out.println(LEADNAME);
		
		Thread.sleep(8000);
	}


}
