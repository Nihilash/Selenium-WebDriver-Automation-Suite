package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFunctionWithXpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to login page
        driver.get("https://the-internet.herokuapp.com/login");

        // Enter WRONG username & password
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("wrongUser");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("wrongPass");

        // Click Login button using XPath with normalize-space(text())
        driver.findElement(By.xpath("//button[i[@class='fa fa-2x fa-sign-in']]")).click();

        Thread.sleep(2000);

        // Capture error message using contains(text())
        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='flash' and contains(text(),'Your username is invalid!')]"));
        System.out.println("Error Message: " + errorMsg.getText().trim());

        Thread.sleep(2000);

        // Now login with correct credentials
        driver.findElement(By.xpath("//input[@id='username']")).clear();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

        // Click login again
        driver.findElement(By.xpath("//button[i[@class='fa fa-2x fa-sign-in']]")).click();

        Thread.sleep(2000);

        // Capture success message
        WebElement successMsg = driver.findElement(By.xpath("//div[@id='flash' and contains(text(),'You logged into a secure area!')]"));
        System.out.println("Success Message: " + successMsg.getText().trim());

        // Close browser
        driver.quit();
    }
}

