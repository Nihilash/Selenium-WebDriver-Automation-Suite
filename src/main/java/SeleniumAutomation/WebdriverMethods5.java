package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMethods5 {
    public static void main(String[] args) throws InterruptedException { 
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com"); // navigate to webpage
        Thread.sleep(2000);

        // locator - tagName (example: find first link on page)
        /*WebElement firstLink = driver.findElement(By.tagName("a"));
        Thread.sleep(2000);
        firstLink.click();*/

        // locator - id
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        Thread.sleep(2000);
        usernameField.clear(); // clear the field if needed

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(2000);
        passwordField.clear();

        // locator - name (just for demonstration, Sauce Demo fields don't have 'name' attribute)
        /*WebElement dummyNameField = driver.findElement(By.name("dummyName"));
        dummyNameField.sendKeys("Test");
        Thread.sleep(2000);
        dummyNameField.clear();*/

        // locator - className (example: login button class)
        WebElement loginBtn = driver.findElement(By.className("btn_action"));
        Thread.sleep(2000);
        loginBtn.click();

        Thread.sleep(3000); // wait to see result
        driver.quit(); // close browser
    }
}