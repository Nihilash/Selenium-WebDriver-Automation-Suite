package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// Uncomment the driver you want to use
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleSauceDemoLoginCssTagSelector {
    public static void main(String[] args) throws InterruptedException {
        // 1) Choose your browser by uncommenting one of these:
        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        System.out.println("✅ SauceDemo page opened successfully");
        Thread.sleep(2000);

        // 2) Enter Username (using tag[attribute='value'])
        WebElement usernameField = driver.findElement(By.cssSelector("input[id='user-name']"));
        usernameField.sendKeys("standard_user");
        System.out.println("✅ Username entered successfully");
        Thread.sleep(1000);

        // 3) Enter Password (using tag[attribute='value'])
        WebElement passwordField = driver.findElement(By.cssSelector("input[id='password']"));
        passwordField.sendKeys("secret_sauce");
        System.out.println("✅ Password entered successfully");
        Thread.sleep(1000);

        // 4) Click Login button (using tag[attribute='value'])
        WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit'][id='login-button']"));
        System.out.println("✅ Login button found successfully");
        Thread.sleep(1000);
        loginBtn.click();
        System.out.println("✅ Login button clicked successfully");

        // 5) Final confirmation message
        System.out.println("🚀 Login process initiated. Please verify success on the page.");
        
        // Optionally, you can add a check here to confirm login was successful:
        // e.g., check for presence of element like "#inventory_container" etc.
    }
}
