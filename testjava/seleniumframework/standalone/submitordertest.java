package seleniumframework.standalone;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.pageobject.cartpage;
import selenium.pageobject.landingpage;
import selenium.pageobject.productcatalog;
import selenium.pageobject.selectcountrypage;
import seleniumframework.bastestcomponents.basetest;

public class submitordertest extends basetest {
	@Test
	public void submitorder() throws IOException {
		// public static void main(String[] args) {
		String pname = "ZARA COAT 3";
		// landingpage landingpage=Launchapplication();
		/*
		 * landingpage landingpage = new landingpage(driver); login.gotourl();
		 */
		productcatalog productcatalog = landingpage.landinglogin("simplypv@gmail.com", "Jokovika@123");
		// productcatalog productcatalog = new productcatalog(driver);
		List<WebElement> products = productcatalog.productvisiblity();
		productcatalog.clickonproduct(pname);
		// Thread.sleep(4);
		cartpage cartpage = productcatalog.cartclick();
		// cartpage cartpage = new cartpage(driver);
		Boolean match = cartpage.checkcartElement(pname);
		// Assert.assertTrue(match);
		selectcountrypage selectcountrypage = cartpage.checkout();
		// selectcountrypage selectcountrypage = new selectcountrypage(driver);
		selectcountrypage.selectcountry("india");

	}

}
