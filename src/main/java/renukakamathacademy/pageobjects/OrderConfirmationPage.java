package renukakamathacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import renukakamathacademy.abstractcomponents.AbstractComponent;

public class OrderConfirmationPage extends AbstractComponent{

	WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String VerifyConfirmationMessage()
	{
		waitTillObjectVisibility(confirmationMessage);
		return confirmationMessage.getText();
	}
	
}
