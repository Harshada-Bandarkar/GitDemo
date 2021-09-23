package HubspotTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import basepackage.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@BeforeMethod
	public void setup()
	{
		
		launchApp();
	}
	
	@Test
	public void getLoginPageTitle()
	{
		String actualTitle=page.getInstance(LoginPage.class).getLoginPageTitle();
		Assert.assertEquals(actualTitle,"HubSpot Login");
	}
	
	@Test
	public void getLoginPageHeader()
	{
		String LoginPageHeader=page.getInstance(LoginPage.class).getLoginPageHeader();
		Assert.assertEquals(LoginPageHeader,"Don't have an account?");
	}
	
	@Test
	public void doLoginTest()
	{
		HomePage homepage=page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println(homepage.getHomePageTitle());
		
	}
	
	@Test
	public void dem()
	{
		System.out.println("P:)");
		System.out.println("bhag");
	}
}
