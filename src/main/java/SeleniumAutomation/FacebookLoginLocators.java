package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginLocators {
    public static void main(String[] args) throws InterruptedException { 
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        System.out.println("Facebook page opened successfully");
        Thread.sleep(2000);

        // Enter Username (using id locator)
        WebElement usernameField = driver.findElement(By.id("email"));
        usernameField.sendKeys("Manu");
        System.out.println("Username entered successfully");
        Thread.sleep(2000);

        // Enter Password (using id locator)
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Manu123@");
        System.out.println("Password entered successfully");
        Thread.sleep(2000);

        // Click Login button (using name locator)
        WebElement loginBtn = driver.findElement(By.name("login"));
        System.out.println("Login button found successfully");
        Thread.sleep(2000);
        loginBtn.click();
        System.out.println("Login button clicked successfully");

        // After Login
        System.out.println("Login process initiated. Please check Facebook for result.");
    }
}
