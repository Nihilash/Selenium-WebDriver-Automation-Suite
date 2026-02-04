package Xpath;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupExample {
    public static void main(String[] args) throws Exception {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the target website
        driver.get("https://practice-automation.com/popups/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ---------------------- JavaScript Popups ----------------------

        // 1. Simple Alert
        driver.findElement(By.id("alert")).click(); // Click the alert button
        Alert simpleAlert = driver.switchTo().alert(); // Switch to alert
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        Thread.sleep(2000);
        simpleAlert.accept(); // Click OK to close

        // 2. Confirmation Popup
        driver.findElement(By.id("confirm")).click(); // Click the confirm button
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Text: " + confirmAlert.getText());
        Thread.sleep(2000);
        confirmAlert.dismiss(); // Click Cancel (use accept() to click OK)

        // 3. Prompt Popup
        driver.findElement(By.id("prompt")).click(); // Click the prompt button
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Nihilash"); // Enter text in prompt
        Thread.sleep(2000);
        promptAlert.accept(); // Click OK

        // Wait for the output element showing submitted name
        WebElement promptOutput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("promptResult"))
        );
        System.out.println("Prompt Output on Page: " + promptOutput.getText());

        // Close the browser
        driver.quit();
    }
}
