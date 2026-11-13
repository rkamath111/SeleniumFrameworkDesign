package renukakamathacademy.testcomponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import renukakamathacademy.pageobjects.loginPage;

public class BaseTest {
	
	public WebDriver driver;
	public loginPage loginpage;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties ps = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\renukakamathacademy\\resourses\\GlobalData.properties");
		ps.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): ps.getProperty("browser");
		
		System.out.println("Browser from command line: " + System.getProperty("browser"));
		System.out.println("Final browserName: " + browserName);
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.getProperty("webdriver.browser.edge","C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		    driver = new EdgeDriver();
		}
		else
		{
		    throw new RuntimeException("Invalid browser name: " + browserName);
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public String addScreenshots(String testCaseName,WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//Reports//"+testCaseName+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	@BeforeMethod(alwaysRun=true)
	public loginPage lauchApplication() throws IOException
	{
		driver = initializeDriver();
		loginpage = new loginPage(driver);
		loginpage.goTo();
		System.out.println("Lauched");
		return loginpage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}
}
