package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMethods4 {

    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("[INFO] Browser launched and maximized.");

        // Navigate to SauceDemo
        driver.get("https://www.saucedemo.com");
        System.out.println("[INFO] Opened SauceDemo login page.");

        // ---------- Locator by tagName ----------
        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("[INFO] tagName found link with text: " + firstLink.getText());
        Thread.sleep(2000);
        firstLink.click();
        System.out.println("[SUCCESS] tagName: Clicked first <a> tag → navigated to: " + driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().back();
        System.out.println("[INFO] tagName section executed and navigated back.\n");

        // ---------- Locator by id ----------
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");
        Thread.sleep(2000);
        emailField.clear();
        System.out.println("[SUCCESS] id: Entered and cleared Username field.\n");

        // ---------- Locator by name ----------
        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");
        Thread.sleep(2000);
        userName.clear();
        System.out.println("[SUCCESS] name: Entered and cleared Username field.\n");

        // ---------- Locator by className ----------
        WebElement password = driver.findElement(By.className("input_error"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        password.clear();
        System.out.println("[SUCCESS] className: Entered and cleared Password field.\n");

        // Close browser
        driver.quit();
        System.out.println("[INFO] Browser closed successfully. Program finished.");
    }
}
