package SeleniumAutomation.Seleniumbesant;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceDemoLoginAllLocators {
    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome in Guest mode (prevents password popup)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);

        //  className → get all usernames
        String[] allUsers = driver.findElement(By.className("login_credentials"))
                                  .getText().split("\n");

        List<String> usernames = new ArrayList<>();
        for (int i = 1; i < allUsers.length; i++) {
            usernames.add(allUsers[i].trim());
        }

        //  className → get password
        String password = driver.findElement(By.className("login_password"))
                                .getText().split("\n")[1].trim();

        for (String user : usernames) {
            System.out.println("\n Trying login with: " + user);

            //  name → username field
            driver.findElement(By.name("user-name")).clear();
            driver.findElement(By.name("user-name")).sendKeys(user);
            Thread.sleep(500);

            //  cssSelector → password field
            driver.findElement(By.cssSelector("input[data-test='password']")).clear();
            driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys(password);
            Thread.sleep(500);

            //  className → login button
            driver.findElement(By.className("submit-button")).click();
            Thread.sleep(1500);

            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("  Login success for: " + user);

                //  id → menu button
                driver.findElement(By.id("react-burger-menu-btn")).click();
                Thread.sleep(1000);

                //  linkText / partialLinkText → logout link
                try {
                    driver.findElement(By.linkText("Logout")).click();
                } catch (NoSuchElementException e) {
                    driver.findElement(By.partialLinkText("Log")).click();
                }

                Thread.sleep(1000);
                System.out.println(" Logged out for: " + user);
            } else {
                System.out.println(" Login failed for: " + user);

                //  tagName → count input fields on login page
                int inputCount = driver.findElements(By.tagName("input")).size();
                System.out.println(" Found " + inputCount + " input fields on login page.");

                driver.get("https://www.saucedemo.com");
                Thread.sleep(1000);
            }
        }

        driver.quit();
        System.out.println("\n Finished testing all users.");
    }
}
