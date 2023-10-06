package selenium.abstractpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.pageobject.cartpage;

public class abstractcomponents {
	WebDriver driver;
	public abstractcomponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (css="[routerlink*='cart']") 
			WebElement cart;
			

	public void visiblityofelement(By findby)
	{
		WebDriverWait Wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void invisiblityofelement(By findby)
	{
		WebDriverWait Wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
		
	}
	public cartpage cartclick()
	{
		cart.click();
		cartpage cartpage = new cartpage(driver);
		return cartpage;
	}
	

}
