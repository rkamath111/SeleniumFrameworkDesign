package renukakamathacademy.abstractcomponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import renukakamathacademy.pageobjects.CartPage;
import renukakamathacademy.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public CartPage goToCart()
	{
		cartHeader.click();
		return new CartPage(driver);
	}
	
	public OrderPage goToOrders()
	{
		waitTillObjectVisibility(orderHeader);
		orderHeader.click();
		return new OrderPage(driver);
	}
	
	public void waitTillObjectVisibility(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitTillObjectVisibility(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void waitTillObjectInvisibility(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
	}
}
