package seleniumframework.standalone;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import selenium.pageobject.landingpage;

public class standalonetest {

	public static void main(String[] args) {
		String pname ="ZARA COAT 3";
		System.setProperty("webdriver.chrome.driver", "C://Users//krishna sabnis\\Downloads//chromedriver-win32//chromedriver-win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client/");
		//landingpage login = new landingpage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("simplypv@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jokovika@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait Wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));//wait until visiblity of element located
		List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));//locator of no of product available on  page
		WebElement prod =products.stream().filter(product-> //name of the product which we added in cart
		product.findElement(By.cssSelector("b")).getText().equals(pname)).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//Thread.sleep(4);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cart=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match =cart.stream().anyMatch(carts-> carts.getText().equalsIgnoreCase(pname));
		//Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button ")).click();
		Actions move = new Actions(driver);
		move.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		driver.close();
		
	    
		
	
		
	
		
	
  }

}
