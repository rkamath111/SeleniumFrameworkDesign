package renukakamathacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import renukakamathacademy.abstractcomponents.AbstractComponent;

public class loginPage extends AbstractComponent 
{
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle; 
	
	@FindBy(id="login")
	WebElement loginSubmit;
	
	@FindBy(css = "div[id='toast-container']")
	WebElement errormessage;
	
	public ProductCatalogue loginApplication(String username, String password)
	{
		useremail.sendKeys(username);
		passwordEle.sendKeys(password);
		loginSubmit.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}
	public String errorMessage()
	{
		waitTillObjectVisibility(errormessage);
		return errormessage.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
