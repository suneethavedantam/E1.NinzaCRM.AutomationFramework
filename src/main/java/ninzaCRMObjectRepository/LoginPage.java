package ninzaCRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rule1
	
		//Rule 2 - Declaration
		@FindBy(id = "username")
		private WebElement  usernameText;
		
		@FindBy(id = "inputPassword")
		private WebElement passwordText;
		
		@FindBy(xpath = ("//button[.='Sign In']"))
		private WebElement loginBtn;
		
		//Rule 3 - Initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Rule 4 - Utilization
		public WebElement getUsernameText() {
			return usernameText;
		}

		public WebElement getPasswordText() {
			return passwordText;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}	
		
		//Business Library - Optimization - generic method
		
		/**
		 * This method will perform Login Operation
		 * @param username
		 * @param password
		 */
		public void loginToApp(String un,String pwd)
		{
			usernameText.sendKeys(un);
			passwordText.sendKeys(pwd);
			loginBtn.click();
		}

}
