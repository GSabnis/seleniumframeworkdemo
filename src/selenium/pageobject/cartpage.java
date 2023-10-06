package selenium.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractpackage.abstractcomponents;

public class cartpage extends abstractcomponents {
	WebDriver driver;
	public cartpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css=".cartSection h3")
			List<WebElement> cart;
	
	@FindBy (css=".totalRow button ")
	WebElement checkout;
	public Boolean checkcartElement(String pname)
	{
		
		Boolean match = cart.stream().anyMatch(carts -> carts.getText().equalsIgnoreCase(pname));
		return match;
	}
	public selectcountrypage checkout()
	{
		checkout.click();
		selectcountrypage selectcountrypage = new selectcountrypage(driver);
		return selectcountrypage;
	}

}
