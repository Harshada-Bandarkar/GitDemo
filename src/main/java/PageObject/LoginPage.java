package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basepackage.BasePage;

/**
 * @author user
 *
 */
public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	private By emailId= By.id("username");
	private By password= By.id("password");
	private By Loginbtn=By.id("loginBtn");
	private By header= By.xpath("//div[contains(@class,'marketing')]/form/div[position()='1']/i18n-string");
	
	
	
	public WebElement getEmailId() {
		return getElement(emailId);
	}
	
	public WebElement getPassword() {
		return getElement(password);
	}
	
	public WebElement getLoginbtn() {
		 return getElement(Loginbtn);
	}
	
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getLoginPageTitle()
	{
		return getPageTitle();
	}
	
	public String getLoginPageHeader()
	{
		return getPageHeader(header);
	}
	
	public HomePage doLogin(String username, String password)
	{
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginbtn().click();
		
		return getInstance(HomePage.class);
	}
	
	
	public boolean doLogin(String username)
	{
		getEmailId().sendKeys(username);
		
		return getLoginbtn().isEnabled();
		
		
	}
	
	
	
	

}
