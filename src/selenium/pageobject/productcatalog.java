package selenium.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.abstractpackage.abstractcomponents;

public class productcatalog extends abstractcomponents {
	WebDriver driver;

	public productcatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;//locator of no of product available on  page

	By productlist = By.cssSelector(".mb-3");//wait until visiblity of element located
	By clickproduct = By.xpath("//button[@class='btn w-10 rounded']");
	By toastmessage = By.cssSelector("#toast-container");
	By animating = By.cssSelector(".ng-animating");

	public List<WebElement> productvisiblity() {
		// TODO Auto-generated method stub
		visiblityofelement(productlist);//wait until visiblity of element located
		return products;
	}

	public WebElement getproductname(String pname) {
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(pname)).findFirst()
				.orElse(null);
		return prod;
	}

	public void clickonproduct(String pname) {
		WebElement prod = getproductname(pname); //name of the product which we added in cart
		prod.findElement(clickproduct).click();
		visiblityofelement(toastmessage);
		invisiblityofelement(animating);
      
	}

}
