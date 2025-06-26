package ninzaCRMPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ninzaCRM.GenericUtilities.JavaUtility;
import ninzaCRM.GenericUtilities.SeleniumUtility;
import ninzaCRM.GenericUtilities.PropertyFileUtility;


public class Practice 
{
	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility fUtil =new PropertyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		String URL = fUtil.readDataFromPropertyFile("url");
	    String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		WebDriver driver=new FirefoxDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addimplicitlyWait(driver);
		
		driver.get(URL);
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
	}

}
