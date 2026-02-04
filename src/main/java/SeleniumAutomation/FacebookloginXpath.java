package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookloginXpath {
    public static void main(String[] args) throws InterruptedException { 
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        System.out.println("Facebook page opened successfully");
        Thread.sleep(2000);

        // Enter Username
        WebElement usernameField = driver.findElement(By.xpath("//input[@type='text']"));
        usernameField.sendKeys("Manu");
        System.out.println("Username entered successfully");
        Thread.sleep(2000);

        // Enter Password
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("Manu123@");
        System.out.println("Password entered successfully");
        Thread.sleep(2000);

        // Click Login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@value='1']"));
        System.out.println("Login button found successfully");
        Thread.sleep(2000);
        loginBtn.click();
        System.out.println("Login button clicked successfully");

        // After Login
        System.out.println("Login process initiated. Please check Facebook for result.");
    }
}
