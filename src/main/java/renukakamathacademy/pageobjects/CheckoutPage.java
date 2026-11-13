package renukakamathacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import renukakamathacademy.abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement selectCountryInput;

	//@FindBy(xpath="//button[contains(@class,'ta-item') and contains(.,'India')]")
	//WebElement countrySelection;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement countrySelection;
	
	@FindBy(css=".action__submit")
	WebElement placeOrderButton;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String country) {
		// TODO Auto-generated method stub
		selectCountryInput.sendKeys(country);
		waitTillObjectVisibility(results);
		countrySelection.click();
	}
	
	public OrderConfirmationPage placeOrder()
	{
		scrollDown();
		waitTillObjectVisibility(placeOrderButton);
		placeOrderButton.click();
		return new OrderConfirmationPage(driver);
	}
}
