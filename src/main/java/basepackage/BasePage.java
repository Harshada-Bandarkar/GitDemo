package basepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) 
	{
		super(driver);
		
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		// TODO Auto-generated method stub
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		WebElement element=null;
		try
		{
		return driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some error occured while creating element "+ locator.toString());
		}
		return element;
	}
	@Override
	public void waitForElementPresent(By locator) {
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		catch(Exception e)
		{
			System.out.println(" Some exception/error occured while waiting for element "+locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) {
	
		try
		{
			//wait.until(ExpectedConditions.)
			wait.until(ExpectedConditions.titleContains(title));
		}
		
		catch(Exception e)
		{
			System.out.println("Some exception/error occured while waiting for element "+title);
		}
	}

}
