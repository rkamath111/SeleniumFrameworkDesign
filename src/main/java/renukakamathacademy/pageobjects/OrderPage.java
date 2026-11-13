package renukakamathacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import renukakamathacademy.abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderList;
	
	By orders = By.cssSelector("tr td:nth-child(3)");

	public Boolean checkProductinOrders(String product) 
	{
		// TODO Auto-generated method stub
		waitTillObjectVisibility(orders);
		Boolean match = orderList.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}
}


