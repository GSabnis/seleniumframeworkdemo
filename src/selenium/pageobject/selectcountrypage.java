package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.abstractpackage.abstractcomponents;

public class selectcountrypage extends abstractcomponents {
    WebDriver driver;
	public selectcountrypage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement buttonclick;
	@FindBy (css =".action__submit")
	WebElement submit;
	public void selectcountry(String countryname)
	{
		Actions move = new Actions(driver);
		move.sendKeys(country, countryname).build().perform();
		visiblityofelement(By.cssSelector(".ta-results"));
		buttonclick.click();
		submit.click();
	}

}
