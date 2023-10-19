package seleniumframework.standalone;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class demo1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\java\\Selenium_Webdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.webdriveruniversity.com/Data-Table/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        HashMap<String ,Integer> map = new HashMap<String ,Integer>();
        map.put("John", 45);
        map.put("Jemma", 94);
        map.put("Michael", 20);
        
       List <WebElement> names=driver.findElements(By.xpath("//tr/td[1]"));
       for(int i=0;i<names.size();i++)
       {
    	
    	System.out.println(names.get(i).getText());
    	   
       }
       List <WebElement> age=driver.findElements(By.xpath("//tr/td[3]"));
       for(int i=0;i<age.size();i++)
       {
    	
    	System.out.println(age.get(i).getText());
    	   
       }
     
      

	}

}
