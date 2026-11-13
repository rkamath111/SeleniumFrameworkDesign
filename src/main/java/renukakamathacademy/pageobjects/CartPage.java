package renukakamathacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import renukakamathacademy.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	
	By cartProducts = By.cssSelector(".cartSection h3"); 
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton;

	public Boolean checkProductinCart(String product) {
		// TODO Auto-generated method stub
		waitTillObjectVisibility(cartProducts);

		Boolean match = cartProduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}

	public CheckoutPage checkout() {
		// TODO Auto-generated method stub
		scrollDown();
		checkoutButton.click();
		return new CheckoutPage(driver);
	}
}
