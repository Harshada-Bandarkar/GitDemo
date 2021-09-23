package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import PageObject.HomePage;

public class BaseTest {

	
	public static WebDriver driver;
	public static Properties prop;
	public Page page;
	
	@BeforeTest
	public void loadconfig() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//Confiuration//config.properties");
		prop.load(fis);
	}
	
	public void launchApp()
	{
		String name=prop.getProperty("browser");
		if(name.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (6)\\chromedriver.exe");
			driver=new ChromeDriver();
	
		}
		
		else if(name.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (3)\\chromedriver.exe");
			driver=new ChromeDriver();
	
		}
		
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (6)\\chromedriver.exe");
			driver=new InternetExplorerDriver();
		}
		
		page=new BasePage(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//page.waitForElementPresent(page.getInstance(LoginPage).get)
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	public String getFailedTestCasesScreens(String TcName, WebDriver driver) throws IOException
	{	String Timestamp=System.currentTimeMillis()+".png";
		TakesScreenshot sc=(TakesScreenshot)driver;
		File source=sc.getScreenshotAs(OutputType.FILE);
		String locationOfScreen=System.getProperty("user.dir")+"\\Screenshot\\"+TcName+Timestamp;
		 
		FileUtils.copyFile(source,new File(locationOfScreen));
		
		return locationOfScreen;
	}
}
