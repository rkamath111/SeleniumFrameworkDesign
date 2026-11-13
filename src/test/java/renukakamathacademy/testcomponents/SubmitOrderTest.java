package renukakamathacademy.testcomponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import renukakamathacademy.data.Data;
import renukakamathacademy.pageobjects.CartPage;
import renukakamathacademy.pageobjects.CheckoutPage;
import renukakamathacademy.pageobjects.OrderConfirmationPage;
import renukakamathacademy.pageobjects.OrderPage;
import renukakamathacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	@Test(dataProvider="getData", groups= {"Purchase"}, retryAnalyzer = Retry.class)
	public void submitOrder(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub
		ProductCatalogue productcatalogue = loginpage.loginApplication(input.get("username"), input.get("password"));
		productcatalogue.findAndSelectProduct(input.get("product"));
		CartPage cartPage = productcatalogue.goToCart();
		Boolean match = cartPage.checkProductinCart(input.get("product"));
		System.out.println("Product found in the cart: "+match);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.checkout();
		checkoutPage.selectCountry("Ind");
		OrderConfirmationPage confirmationpage = checkoutPage.placeOrder();
		String confMessage = confirmationpage.VerifyConfirmationMessage();
		System.out.println(confMessage);
		Assert.assertEquals(confMessage, "THANKYOU FOR THE ORDER.");
	}
	
	@Test(dataProvider="getData", dependsOnMethods = "submitOrder")
	public void verifyOrder(HashMap<String,String> input)
	{
		ProductCatalogue productcatalogue = loginpage.loginApplication(input.get("username"), input.get("password"));
		OrderPage orderPage = productcatalogue.goToOrders();
		Boolean match = orderPage.checkProductinOrders(input.get("product"));
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData() throws StreamReadException, DatabindException, IOException
	{
		
		Data dataObject = new Data();
		List<HashMap<String,String>> data = dataObject.DataMethod(System.getProperty("user.dir")+"\\src\\main\\java\\renukakamathacademy\\data\\Data.json");
		//return new Object[][]{{"anshika@anshika.com","Anshika@123","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
}
