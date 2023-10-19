package seleniumframework.standalone;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class SeleniumDataInput {
	    public static void main(String[] args) {
	        // Set up WebDriver and open the webpage
	    	System.setProperty("webdriver.chrome.driver", "D:\\java\\Selenium_Webdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        // Define your data in the List of Maps
	        List<Map<String, Object>> inputList = List.of(
	            Map.of("name", "Bob", "age", 20, "gender", "male"),
	            Map.of("name", "George", "age", 42, "gender", "male"),
	            Map.of("name", "Sara", "age", 42, "gender", "female"),
	            Map.of("name", "Conor", "age", 40, "gender", "male"),
	            Map.of("name", "Jennifer", "age", 42, "gender", "female")
	        );

	        // Create a HashMap using the input data
	        Map<String, Map<String, Object>> hashMap = new HashMap<>();
	        for (Map<String, Object> item : inputList) 
	        {
	            String name = (String) item.get("name");
	            hashMap.put(name, item);
	        }

	        // Find the textbox element where you want to input data
	        driver.findElement(By.xpath("//summary[normalize-space()='Table Data']")).click();
	        WebElement data = driver.findElement(By.id("jsondata"));

	        // Iterate over the HashMap and send the data to the textbox
	        StringBuilder jsonData = new StringBuilder();
	        for (Map.Entry<String, Map<String, Object>> entry : hashMap.entrySet()) 
	        {
	            String name = entry.getKey();
	            Map<String, Object> dataMap = entry.getValue();
	            jsonData.append("Name: ").append(name)
	                    .append(", Age: ").append(dataMap.get("age"))
	                    .append(", Gender: ").append(dataMap.get("gender"))
	                    .append("\n");
	        }

	        // Input the data into the textbox
	        data.sendKeys(jsonData.toString());
            driver.findElement(By.id("refreshtable")).click();
	        // Close the browser
	       // driver.quit();
	    }
	}



