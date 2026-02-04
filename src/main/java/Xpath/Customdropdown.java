package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Customdropdown {
    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open local HTML file
        driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/dropdowncustom.html");

        // Click on the custom dropdown to open options
        WebElement dropdown = driver.findElement(By.className("custom-dropdown"));
        dropdown.click();

        // Wait a little (can also use explicit wait)
        Thread.sleep(1000);

        // Get all options
        List<WebElement> options = driver.findElements(By.cssSelector(".dropdown-options div"));

        // Loop through options and select JavaScript
        for (WebElement option : options) {
            if (option.getText().equals("JavaScript")) {
                option.click();
                break;
            }
        }

        // Print the selected option
        WebElement selected = driver.findElement(By.id("selectedOption"));
        System.out.println("Selected Language: " + selected.getText()); // Output: JavaScript

        driver.quit();
    }
}
