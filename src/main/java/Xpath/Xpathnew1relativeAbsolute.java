package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xpathnew1relativeAbsolute {
	public static void main(String[] args) throws InterruptedException {
		//setting the path of the edge driver
		System.setProperty("webdriver.edge.driver", 
	            "D:\\besant\\java ecllipse1\\SeleniumAutomation\\DriverLinks\\edgedriver_win64\\msedgedriver.exe");
		// Initialize EdgeDriver
        WebDriver driver = new EdgeDriver();
        // Open the local HTML file
        driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/new%201.html");
        System.out.println(driver.getTitle());
        // Maximize browser window
        driver.manage().window().maximize();
        // Initialize Actions for hover
        Actions actions = new Actions(driver);
        // ----------------- Using Absolute XPath -----------------
        System.out.println("----------------- Using Absolute XPath -----------------");
        WebElement pythonBoxAbsolute = driver.findElement(By.xpath("/html/body/div[1]/div[1]"));
        actions.moveToElement(pythonBoxAbsolute).perform();
        System.out.println(pythonBoxAbsolute.getText());
        Thread.sleep(1000); // pause to see highlight
        System.out.println("----------------- Using Absolute XPath -----------------");
        WebElement WebDevelopmentBoxAbsolute = driver.findElement(By.xpath("/html/body/div[1]/div[2]"));
        actions.moveToElement(WebDevelopmentBoxAbsolute).perform();
        System.out.println(WebDevelopmentBoxAbsolute.getText());
        Thread.sleep(1000); // pause to see highlight
        System.out.println("----------------- Using Absolute XPath -----------------");
        WebElement dataBoxAbsolute = driver.findElement(By.xpath("/html/body/div[1]/div[3]"));
        actions.moveToElement(dataBoxAbsolute).perform();
        System.out.println(dataBoxAbsolute.getText());
        Thread.sleep(1000);
        
     // ----------------- Using Relative XPath -----------------
        System.out.println("----------------- Using Relative XPath -----------------");
        WebElement pythonBoxRelative = driver.findElement(By.xpath("//div[@class='course-container']/div[1]"));
        actions.moveToElement(pythonBoxRelative).perform();
        System.out.println(pythonBoxRelative.getText());
        Thread.sleep(1000);
        System.out.println("----------------- Using Relative XPath -----------------");
        WebElement webBoxRelative = driver.findElement(By.xpath("//div[@class='course-container']/div[2]"));
        actions.moveToElement(webBoxRelative).perform();
        System.out.println(webBoxRelative.getText());
        Thread.sleep(1000);
        System.out.println("----------------- Using Relative XPath -----------------");
        WebElement dataBoxRelative = driver.findElement(By.xpath("//div[@class='course-container']/div[3]"));
        actions.moveToElement(dataBoxRelative).perform();
        System.out.println(dataBoxRelative.getText());
        Thread.sleep(1000);

        // Close the browser
        driver.quit();
        

	}
}
