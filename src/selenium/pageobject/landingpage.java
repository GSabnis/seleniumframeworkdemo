package selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractpackage.abstractcomponents;
//in a page objects we only do selenium methods and actions no hardcoded data allowed here
public class landingpage extends abstractcomponents {
	WebDriver driver;
//by using constructor we are invoking driver of submitordertest class  to the landing page to perform operations	
	public landingpage(WebDriver driver)

	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//here with the help of initElement we are invoking findBy these are all driver.findelement methods
	@FindBy(id="userEmail")
	WebElement email;
	@FindBy(id="userPassword")
	WebElement pass;
	@FindBy(id="login")
	WebElement Loginbutton;
//here by gotourl method we are  writing url action and to invoke this method we have created landingpage object in submitorder class
	public void gotourl()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
public productcatalog landinglogin(String emailid , String password)
{
	email.sendKeys(emailid);
	pass.sendKeys(password);
	Loginbutton.click();
	productcatalog productcatalog = new productcatalog(driver);
	return productcatalog;
	
}

}
