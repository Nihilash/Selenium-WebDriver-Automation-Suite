package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class XpathSiblingFunctions  {
    public static void main(String[] args) throws InterruptedException {
        // Chrome options to block popups
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--guest");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000); // Wait for page to load

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ---------------- Login ----------------
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000); // Wait after login

        // Wait for inventory page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        Thread.sleep(500);

        // ---------------- Click Backpack using id="item_4_img_link" ----------------
        WebElement backpack = driver.findElement(By.id("item_4_img_link"));
        backpack.click();
        Thread.sleep(1000); // Wait for animation

        // Wait for Backpack details page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_container")));
        Thread.sleep(500);

        // ---------------- Forward Traversal ----------------
        WebElement nameElement = driver.findElement(By.className("inventory_details_name"));
        WebElement priceElement = nameElement.findElement(
                By.xpath("./following-sibling::div[@class='inventory_details_price']")
        );
        System.out.println("Forward Traversal:");
        System.out.println("Price: " + priceElement.getText());
        Thread.sleep(500);

        // ---------------- Backward Traversal ----------------
        WebElement nameFromPrice = priceElement.findElement(
                By.xpath("./preceding-sibling::div[contains(@class,'inventory_details_name')]")
        );
        System.out.println("Backward Traversal:");
        System.out.println("Name: " + nameFromPrice.getText());
        Thread.sleep(500);

        // ---------------- Open Burger Menu → Click All Items ----------------
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
        Thread.sleep(1000); // Wait for menu animation

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_sidebar_link")));
        WebElement allItems = driver.findElement(By.id("inventory_sidebar_link"));
        allItems.click();
        Thread.sleep(1000); // Wait after clicking All Items

        // Wait to ensure returned to inventory page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        Thread.sleep(500);
        System.out.println("\nReturned to All Items page successfully.");

        driver.quit();
    }
}