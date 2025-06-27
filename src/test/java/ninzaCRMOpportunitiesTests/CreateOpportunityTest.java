package ninzaCRMOpportunitiesTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRMObjectRepository.CampaignPage;
import ninzaCRMObjectRepository.CreateCampaignPage;
import ninzaCRMObjectRepository.CreateLeadPage;
import ninzaCRMObjectRepository.CreateOpportunitiesPage;
import ninzaCRMObjectRepository.LeadsPage;
import ninzaCRMObjectRepository.OpportunitiesPage;

public class CreateOpportunityTest extends BaseClass{
	
	@Test
	public void tc_03_createOpportunityWithLead() throws EncryptedDocumentException, IOException, InterruptedException
	{
	
	
	String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 7, 2)+jUtil.getRandomNumber();
	System.out.println(CAMPAIGNNAME);
	String TARGETSIZE = eUtil.readDataFromExcel("Integration", 7, 3);
	
	String LEADNAME = eUtil.readDataFromExcel("Integration", 7, 4)+jUtil.getRandomNumber();
	System.out.println(LEADNAME);
	String COMPANY = eUtil.readDataFromExcel("Integration", 7, 5);
	String LEADSOURCE = eUtil.readDataFromExcel("Integration", 7, 6);
	String LEADSTATUS = eUtil.readDataFromExcel("Integration", 7, 7);
	String INDUSTRY = eUtil.readDataFromExcel("Integration", 7, 8);
	String RATING = eUtil.readDataFromExcel("Integration", 7, 9);
	String PHONE = eUtil.readDataFromExcel("Integration", 7, 10);
	String OPPORTUNITYNAME = eUtil.readDataFromExcel("Integration", 7, 11);
	String AMOUNT = eUtil.readDataFromExcel("Integration", 7, 12);
	String BUSINESSTYPE = eUtil.readDataFromExcel("Integration", 7, 13);
	String NEXTSTEP = eUtil.readDataFromExcel("Integration", 7, 14);
	String SALESSTAGE = eUtil.readDataFromExcel("Integration", 7, 15);
	String PROBABILITY = eUtil.readDataFromExcel("Integration", 7, 16);
	
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
		clp.createLeadWithCampaign(driver,LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS, RATING, CAMPAIGNNAME);
			
		Thread.sleep(8000);
		//Click on opportunities Link
		cp.clickOnOpportunitiesLnk();
		
		//click on create opportunity button
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickOnCreateOpportunityBtn();
			
		//Create opportunity with mandatory fields
		CreateOpportunitiesPage cop = new CreateOpportunitiesPage(driver);
		cop.createOpportunityWithLead(driver, OPPORTUNITYNAME, AMOUNT, BUSINESSTYPE, NEXTSTEP, SALESSTAGE,PROBABILITY, LEADNAME,CAMPAIGNNAME);
		
		//Validate for the OPPORTUNITY
	    op.captureOpportuniesNamesAndCompare(OPPORTUNITYNAME);
		System.out.println(OPPORTUNITYNAME);
			
			Thread.sleep(8000);
			
		//Logout 
		WebElement ele = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
			
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		System.out.println("Logout successful");
		}
	
}
