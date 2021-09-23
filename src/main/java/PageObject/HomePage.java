package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepackage.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By header=By.className("private-page__title");

	public String getHeader() {
		return getPageHeader(header);
	}
	
	public String getHomePageTitle()
	{
		return getPageTitle();
	}

	
	
	
}
