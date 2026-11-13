package renukakamathacademy.testcomponents;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("anshika@anshika.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anshika@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".col-lg-4"))));
		List<WebElement> list=driver.findElements(By.cssSelector(".col-lg-4"));
		WebElement product = list.stream()
							.filter(n->n.findElement(By.tagName("b"))
							.getText()
							.equalsIgnoreCase("ZARA COAT 3")).findFirst().orElseThrow(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		Boolean flag=driver.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase("ZARA COAT 3");
		//Assert.assertTrue(flag);
		System.out.println(flag);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		a.sendKeys(driver.findElement(By.cssSelector("button[class='ta-item list-group-item ng-star-inserted']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(confMessage, "THANKYOU FOR THE ORDER");
	}
}
