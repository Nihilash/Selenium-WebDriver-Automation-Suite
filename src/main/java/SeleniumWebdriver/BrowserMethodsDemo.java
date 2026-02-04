package SeleniumWebdriver.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserMethodsDemo {
    public static void main(String[] args) throws InterruptedException {
        // Set the driver path
        System.setProperty("webdriver.edge.driver", 
            "D:\\besant\\java ecllipse1\\SeleniumAutomation\\DriverLinks\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        // 1. Open Google
        driver.get("https://www.google.com");
        Thread.sleep(2000);  // wait for 2 sec

        // 2. Get Page Title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // 3. Get Current URL
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);

        // 4. Get Page Source length
        String pageSource = driver.getPageSource();
        System.out.println("Page Source Length: " + pageSource.length());
        Thread.sleep(2000);

        // 5. Maximize browser
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // 6. Minimize browser
        driver.manage().window().minimize();
        Thread.sleep(2000);

        // 7. Open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bing.com");
        Thread.sleep(2000);
        System.out.println("New Tab Title: " + driver.getTitle());

        // 8. Switch back to Google tab
        String firstTab = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(firstTab);
        driver.get("https://www.google.com");
        Thread.sleep(2000);

        // 9. Perform search using CSS Selector
        WebElement searchBox = driver.findElement(By.cssSelector("textarea[name='q']"));
        searchBox.sendKeys("Selenium WebDriver");
        Thread.sleep(2000);

        // Using CSS selector by className
        WebElement searchButton = driver.findElement(By.cssSelector("input.gNO89b"));
        searchButton.click();
        Thread.sleep(4000);  // wait to see results

        // 10. Close current tab
        driver.close();
        Thread.sleep(2000);

        // 11. Quit entire browser session
        driver.quit();
    }
}
