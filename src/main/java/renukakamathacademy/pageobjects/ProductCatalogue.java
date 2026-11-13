package renukakamathacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import renukakamathacademy.abstractcomponents.AbstractComponent;


public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".col-lg-4")
	List<WebElement> list;
	
	@FindBy(css=".col-lg-4")
	WebElement productList; 
	
	By AddToCartButton = By.cssSelector(".card-body button:last-of-type");
	
	By productsName = By.tagName("b");
	
	By loader = By.cssSelector(".ng-animating");
	
	By toastMessage = By.cssSelector("#toast-container");
	
	public CartPage findAndSelectProduct(String productname)
	{
		waitTillObjectVisibility(productList);
		System.out.println("Looking for product: " + productname);

	    for (WebElement p : list) {
	        String actualProductName =
	                p.findElement(productsName).getText();

	        System.out.println("Product on page: [" +
	                actualProductName + "]");
	    }
	    	
		WebElement product = list.stream()
				.filter(n->n.findElement(productsName)
				.getText()
				.equalsIgnoreCase(productname)).findFirst().orElseThrow(() -> new RuntimeException("Product not found: " + productname));

		System.out.println("FOUND PRODUCT: " +
        product.findElement(productsName).getText());
		
		System.out.println("Clicking Add To Cart for: " + productname);

		product.findElement(AddToCartButton).click();

		System.out.println("Add To Cart clicked");

		waitTillObjectInvisibility(loader);

		System.out.println("Loader disappeared");

		waitTillObjectVisibility(toastMessage);

		System.out.println("Toast message displayed");
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
