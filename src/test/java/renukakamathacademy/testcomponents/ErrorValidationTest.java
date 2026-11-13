package renukakamathacademy.testcomponents;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import renukakamathacademy.pageobjects.CartPage;
import renukakamathacademy.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest
{
	@Test(priority=1,groups="error validation")
	public void loginErrorValidation()
	{
		loginpage.loginApplication("anshika@ansh.com", "Ansh@123");
		Assert.assertEquals(loginpage.errorMessage(), "Incorrect email or password.");
	}
	
	@Test(priority=2,groups="error validation")
	public void cartProductTest() throws IOException {
		// TODO Auto-generated method stub
		String product = "ZARA COAT 3";
		ProductCatalogue productcatalogue = loginpage.loginApplication("anshika@anshika.com", "Anshika@123");
		productcatalogue.findAndSelectProduct(product);
		CartPage cartPage = productcatalogue.goToCart();
		Boolean match = cartPage.checkProductinCart("ZARA COAT 33");
		System.out.println("Product found in the cart: "+match);
		Assert.assertFalse(match);
	}
}
