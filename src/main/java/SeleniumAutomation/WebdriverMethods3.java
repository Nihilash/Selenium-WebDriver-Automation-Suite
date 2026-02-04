package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMethods3 {

    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to SauceDemo
        driver.get("https://www.saucedemo.com");

        // ---------- Locator by tagName ----------
        // Example: find first <a> tag (not really useful on this page, just for demo)
        // WebElement loginBtn = driver.findElement(By.tagName("a"));
        // Thread.sleep(3000);
        // loginBtn.click();

        // ---------- Locator by id ----------
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        Thread.sleep(3000);
        emailField.clear();

        // Or directly:
        // driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Thread.sleep(3000);
        // driver.findElement(By.id("user-name")).clear();

        // ---------- Locator by name ----------
        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");
        Thread.sleep(2000);
        userName.clear();

        // ---------- Locator by className ----------
        WebElement password = driver.findElement(By.className("input_error"));
        password.sendKeys("secret_sauce");
        Thread.sleep(3000);
        password.clear();

        // Close browser
        driver.quit();
    }
}