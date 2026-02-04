package SeleniumAutomation.Seleniumbesant;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceDemoLoginXPathMultipleUsers {
    public static void main(String[] args) throws InterruptedException {
        // 🚫 Run Chrome in Guest mode (prevents password popup)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        WebDriver driver = new ChromeDriver(options);

        System.out.println("STEP 1: Opening SauceDemo website...");
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);

        // STEP 2: Get all usernames + password
        WebElement usersBox = driver.findElement(By.xpath("//div[@class='login_credentials']"));
        String[] allUsers = usersBox.getText().split("\n");

        List<String> usernames = new ArrayList<>();
        for (int i = 1; i < allUsers.length; i++) {
            usernames.add(allUsers[i].trim());
        }

        String password = driver.findElement(By.className("login_password")).getText()
                                .split("\n")[1].trim();
        System.out.println(" Common password: " + password);

        // STEP 3 & 4: Try login with each user
        for (String user : usernames) {
            System.out.println("\n Trying login with: " + user);

            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));

            usernameField.clear();
            usernameField.sendKeys(user);
            Thread.sleep(800); //  wait after typing username

            passwordField.clear();
            passwordField.sendKeys(password);
            Thread.sleep(800); //  wait after typing password

            driver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);

            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println(" Login success for: " + user);

                driver.findElement(By.id("react-burger-menu-btn")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("logout_sidebar_link")).click();
                Thread.sleep(2000);
                System.out.println(" Logged out for: " + user);
            } else {
                System.out.println("Login failed for: " + user);
                driver.get("https://www.saucedemo.com");
                Thread.sleep(2000);
            }
        }

        driver.quit();
        System.out.println("\n Finished testing all users.");
    }
}
