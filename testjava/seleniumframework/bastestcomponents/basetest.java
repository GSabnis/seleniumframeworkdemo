package seleniumframework.bastestcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import selenium.pageobject.landingpage;

public class basetest {
	public WebDriver driver;
	public landingpage landingpage;

	public WebDriver initalisedriver() throws IOException {

		Properties prop = new Properties(); // to access the data present in Globaldata.properties
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\krishna sabnis\\eclipse-workspace\\seleniumframework\\src\\selenium\\resources\\Globaldata.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//krishna sabnis\\Downloads//chromedriver-win32//chromedriver-win32//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	@BeforeMethod
	public landingpage Launchapplication() throws IOException

	{
		driver = initalisedriver();
		landingpage = new landingpage(driver);
		landingpage.gotourl();
		return landingpage;

	}

	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}
